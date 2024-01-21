package com.facility.primeSport.service;

import com.facility.primeSport.dto.chart.GraphRequest;
import com.facility.primeSport.dto.chart.GraphResponse;
import com.facility.primeSport.entitiy.analytics.UserDailySnapshot;
import com.facility.primeSport.repo.UserDailySnapshotRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActivitiesService implements IUserActivitiesService {


    private final UserDailySnapshotRepository userDailySnapshotRepository;


    public UserActivitiesService(UserDailySnapshotRepository userDailySnapshotRepository) {
        this.userDailySnapshotRepository = userDailySnapshotRepository;
    }

    @CacheEvict(allEntries = true, value = "findValuesByMount")
    @Scheduled(fixedDelay = 86400)
    private List<UserDailySnapshot> getList(GraphRequest request) {
        return userDailySnapshotRepository.findValuesByMount(request.endDate(), request.today(), request.userId());
    }

    public List<GraphResponse> userActivities(GraphRequest request) {
        String type = switch (request.type()) {
            case "calorie" -> "calories";
            case "sleeping_time" -> "sleep_time";
            case "stress_level" -> "stress_level";
            default -> "steps";
        };

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

    private Integer getValue(String type, UserDailySnapshot data) {
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
