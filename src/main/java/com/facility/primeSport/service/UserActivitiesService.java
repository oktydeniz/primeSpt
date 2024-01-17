package com.facility.primeSport.service;

import com.facility.primeSport.dto.chart.GraphRequest;
import com.facility.primeSport.dto.chart.GraphResponse;
import com.facility.primeSport.entitiy.analytics.UserDailySnapshot;
import com.facility.primeSport.repo.UserDailySnapshotRepository;
import org.hibernate.mapping.Any;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserActivitiesService implements IUserActivitiesService {


    private final UserDailySnapshotRepository userDailySnapshotRepository;


    public UserActivitiesService(UserDailySnapshotRepository userDailySnapshotRepository) {
        this.userDailySnapshotRepository = userDailySnapshotRepository;
    }

    @CacheEvict(allEntries = true, value = "findValuesByMount")
    @Scheduled(fixedDelay = 86400)
    private List<UserDailySnapshot> getList(GraphRequest request){
        return userDailySnapshotRepository.findValuesByMount(request.startDate(), request.endDate(), request.userId());
    }
    public List<GraphResponse> userActivities(GraphRequest request) {
        String type = "";
        if (request.type().equals("step")) {
            type = "steps";
           // return findBySteps(list);
        } else if (request.type().equals("calorie")) {
            type = "calories";
            //return findByCalories(list);
        } else if (request.type().equals("sleeping_time")) {
            type = "sleep_time";
        } else if (request.type().equals("stress_level")) {
            type = "stress_level";
        }

        return group(getList(request), type);
    }


    @Override
    public List<GraphResponse> findBySteps(List<UserDailySnapshot> list) {
        return null;
    }


    private List<GraphResponse> group(List<UserDailySnapshot> list, String type) {
        return list.stream()
                .map(item -> new GraphResponse(item.getSnapshotDate(), getValue(type, item)))
                .collect(Collectors.toList());
    }

    private Integer getValue(String type, UserDailySnapshot data){
        return switch (type) {
            case "steps" -> data.getSteps();
            case "calories" -> data.getCalories();
            case "sleep_time" -> data.getSleepTime();
            case "stress_level" -> data.getStressLevel().setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            default -> null;
        };
    }

    @Override
    public List<GraphResponse> findByCalories(List<UserDailySnapshot> list) {
        return null;
    }
}
