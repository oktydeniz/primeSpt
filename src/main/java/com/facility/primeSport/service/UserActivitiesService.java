package com.facility.primeSport.service;

import com.facility.primeSport.dto.chart.GraphRequest;
import com.facility.primeSport.dto.chart.GraphResponse;
import com.facility.primeSport.entitiy.analytics.UserDailySnapshot;
import com.facility.primeSport.repo.UserDailySnapshotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActivitiesService implements IUserActivitiesService {


    private final UserDailySnapshotRepository userDailySnapshotRepository;


    public UserActivitiesService(UserDailySnapshotRepository userDailySnapshotRepository) {
        this.userDailySnapshotRepository = userDailySnapshotRepository;
    }

    public List<GraphResponse> userActivities(GraphRequest request) {
        String type = "";
        List<GraphResponse> list = userDailySnapshotRepository.findValuesByMount(request.startDate(), request.endDate(), request.userId());
        if (request.type().equals("step")) {
            type = "steps";
        } else if (request.type().equals("calorie")) {
            type = "calories";
        } else if (request.type().equals("sleeping_time")) {
            type = "sleep_time";
        } else if (request.type().equals("stress_level")) {
            type = "stress_level";
        }
        return null;
    }


    @Override
    public List<GraphResponse> findBySteps() {
        return null;
    }
}
