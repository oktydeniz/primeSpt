package com.facility.primeSport.service;


import com.facility.primeSport.dto.fitness.ActivityTypeResponse;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.repo.ActivityTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionData {


    private ActivityTypeRepository activityType;


    public CollectionData(ActivityTypeRepository activityType) {
        this.activityType = activityType;
    }

    public List<ActivityTypeResponse> getActivityTypes(){
        return activityType.findAll().stream().map(ActivityTypeResponse::new).collect(Collectors.toList());
    }

    public ActivityType getActivityType(Long id){
        return activityType.findById(id).orElse(null);
    }
}
