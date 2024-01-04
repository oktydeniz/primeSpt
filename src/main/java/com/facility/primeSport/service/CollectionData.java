package com.facility.primeSport.service;


import com.facility.primeSport.dto.fitness.ActivityTypeResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutListDetailResponse;
import com.facility.primeSport.dto.fitness.PublicActivityWorkoutResponse;
import com.facility.primeSport.dto.fitness.WorkoutResponse;
import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.enums.ActivityGroupType;
import com.facility.primeSport.repo.ActivityTypeRepository;
import com.facility.primeSport.repo.WorkoutRepository;
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

    public boolean deleteWorkoutList(Long id) {
        return publicActivityWorkoutListService.deleteList(id);
    }

    public boolean setPrivate(Long id) {
        return publicActivityWorkoutListService.setPrivate(id);
    }
}
