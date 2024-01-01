package com.facility.primeSport.service;


import com.facility.primeSport.dto.fitness.ActivityTypeResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutListDetailResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutResponse;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.enums.ActivityGroupType;
import com.facility.primeSport.repo.ActivityTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CollectionData {


    private final ActivityTypeRepository activityType;

    private final PublicActivityWorkoutListService publicActivityWorkoutListService;

    private final PublicActivityWorkoutListDetailService publicActivityWorkoutListDetailService;

    public CollectionData(ActivityTypeRepository activityType, PublicActivityWorkoutListService publicActivityWorkoutListService, PublicActivityWorkoutListDetailService publicActivityWorkoutListDetailService) {
        this.activityType = activityType;
        this.publicActivityWorkoutListService = publicActivityWorkoutListService;
        this.publicActivityWorkoutListDetailService = publicActivityWorkoutListDetailService;
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

    public PublicActivityWorkoutResponse getPublicProgramDetail(Long programId) {
        return publicActivityWorkoutListService.findById(programId);

    }

    public Map<ActivityGroupType, List<PublicActivityWorkoutListDetailResponse>> getPublicProgramListDetail(Long programId) {

        return publicActivityWorkoutListDetailService.findById(programId);
    }
}
