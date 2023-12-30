package com.facility.primeSport.dto.fitness;

import com.facility.primeSport.entitiy.fitness.ActivityType;

public class ActivityTypeResponse{

    public Long id;
    public String name;

    public ActivityTypeResponse(ActivityType type){
        this.id = type.getId();
        this.name = type.getActivityType();
    }
}
