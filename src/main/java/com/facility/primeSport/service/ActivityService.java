package com.facility.primeSport.service;

import com.facility.primeSport.dto.fitness.CreateActivityRequest;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.repo.PublicActivityWorkoutRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private UserService userService;

    private PublicActivityWorkoutRepository workoutRepository;

    private CollectionData collectionData;

    public ActivityService(UserService userService, PublicActivityWorkoutRepository workoutRepository, CollectionData collectionData) {
        this.userService = userService;
        this.workoutRepository = workoutRepository;
        this.collectionData = collectionData;
    }

    public ResponseEntity<Boolean> createNewActivity(CreateActivityRequest createActivity, Long id) {
        User user = userService.findUserByUserId(id);
        PublicActivityWorkoutList list = new PublicActivityWorkoutList(createActivity);
        ActivityType type = collectionData.getActivityType(createActivity.activityType());
        list.setOwnerId(user);
        list.setActivityType(type);
        workoutRepository.save(list);
        return ResponseEntity.ok(true);
    }
}
