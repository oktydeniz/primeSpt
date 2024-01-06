package com.facility.primeSport.service;


import com.facility.primeSport.dto.fitness.*;
import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.enums.ActivityGroupType;
import com.facility.primeSport.repo.ActivityTypeRepository;
import com.facility.primeSport.repo.WorkoutRepository;
import com.facility.primeSport.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CollectionData {

    private final ActivityTypeRepository activityType;

    private final PublicActivityWorkoutListService publicActivityWorkoutListService;

    private final PublicActivityWorkoutListDetailService publicActivityWorkoutListDetailService;

    private final WorkoutRepository workoutRepository;

    public CollectionData(ActivityTypeRepository activityType, PublicActivityWorkoutListService publicActivityWorkoutListService, PublicActivityWorkoutListDetailService publicActivityWorkoutListDetailService, WorkoutRepository workoutRepository) {
        this.activityType = activityType;
        this.publicActivityWorkoutListService = publicActivityWorkoutListService;
        this.publicActivityWorkoutListDetailService = publicActivityWorkoutListDetailService;
        this.workoutRepository = workoutRepository;
    }

    public List<ActivityTypeResponse> getActivityTypes() {
        return activityType.findAll().stream().map(ActivityTypeResponse::new).collect(Collectors.toList());
    }

    public ActivityType getActivityType(Long id) {
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

    public WorkoutResponse getWorkout(Long id) {
        Workout workout = workoutRepository.findById(id).orElse(null);
        if (workout != null) {
            return new WorkoutResponse(workout);
        }
        return null;
    }

    public List<WorkoutResponse> getAllWorkouts(){
        return workoutRepository.findAll().stream().map(WorkoutResponse::new).toList();
    }

    public boolean deleteWorkoutList(Long id) {
        return publicActivityWorkoutListService.deleteList(id);
    }

    public boolean setPrivate(Long id) {
        return publicActivityWorkoutListService.setPrivate(id);
    }

    public boolean updateActivityList(PublicActivityListRequest response) {
        PublicActivityWorkoutList list = publicActivityWorkoutListService.findByID(response.id());
        ActivityType type = activityType.findById(response.activity()).orElse(null);
        if (list != null){
            list.setPrivate(response.isPrivate());
            list.setDescription(response.description());
            list.setName(response.name());
            list.setImageUrl(response.imageUrl());
            list.setWorkoutLevel(CommonUtil.findLevel(response.workoutLevel()));
            if (type != null){
                list.setActivityType(type);
            }
            publicActivityWorkoutListService.save(list);
        }
        return true;
    }
}
