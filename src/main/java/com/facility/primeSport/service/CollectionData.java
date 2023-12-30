package com.facility.primeSport.service;


import com.facility.primeSport.dto.fitness.ActivityTypeResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutResponse;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.repo.ActivityTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CollectionData {


    private ActivityTypeRepository activityType;

    private PublicActivityWorkoutListService publicActivityWorkoutListService;

    public CollectionData(ActivityTypeRepository activityType, PublicActivityWorkoutListService publicActivityWorkoutListService) {
        this.activityType = activityType;
        this.publicActivityWorkoutListService = publicActivityWorkoutListService;
    }

    public List<ActivityTypeResponse> getActivityTypes(){
        return activityType.findAll().stream().map(ActivityTypeResponse::new).collect(Collectors.toList());
    }

    public ActivityType getActivityType(Long id){
        return activityType.findById(id).orElse(null);
    }

    public Map<ActivityType, List<PublicActivityWorkoutResponse>> getGroupingActivities() {
        return publicActivityWorkoutListService.getGroupingActivities();
    }

    public List<PublicActivityWorkoutResponse> getByCategory(Long categoryId) {
        return publicActivityWorkoutListService.getByCategoryId(categoryId);
    }
}
