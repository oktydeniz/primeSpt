package com.facility.primeSport.dto.fitness;

import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutList;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.enums.WorkoutLevel;

public class PublicActivityWorkoutResponse {

    private User ownerId;
    private WorkoutLevel workoutLevel;
    private String imageUrl;
    private Integer countOfClicked;
    private Building building;
    private Double rate;
    private Long id;
    private String name;
    private String description;
    private ActivityType activityType;

    private boolean isPrivate;

    public PublicActivityWorkoutResponse(PublicActivityWorkoutList entity) {
        this.activityType = entity.getActivityType();
        this.description = entity.getDescription();
        this.name = entity.getName();
        this.id = entity.getId();
        this.rate = entity.getRate();
        this.building = entity.getBuilding();
        this.countOfClicked = entity.getCountOfClicked();
        this.imageUrl = entity.getImageUrl();
        this.workoutLevel = entity.getWorkoutLevel();
        this.ownerId = entity.getOwnerId();
        this.isPrivate = entity.isPrivate();
    }

    public boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public WorkoutLevel getWorkoutLevel() {
        return workoutLevel;
    }

    public void setWorkoutLevel(WorkoutLevel workoutLevel) {
        this.workoutLevel = workoutLevel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getCountOfClicked() {
        return countOfClicked;
    }

    public void setCountOfClicked(Integer countOfClicked) {
        this.countOfClicked = countOfClicked;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
