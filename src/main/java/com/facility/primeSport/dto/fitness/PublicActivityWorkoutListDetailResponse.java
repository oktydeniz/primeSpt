package com.facility.primeSport.dto.fitness;

import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutListDetail;
import com.facility.primeSport.enums.ActivityGroupType;

public class PublicActivityWorkoutListDetailResponse {

    private Integer repeatCount;

    private Integer setDurationSecond;

    private Integer setCount;

    private String description;

    private Integer workoutOrder;

    private WorkoutResponse workout;

    private ActivityGroupType type;

    private Long id;


    public PublicActivityWorkoutListDetailResponse(PublicActivityWorkoutListDetail detail) {
        this.repeatCount = detail.getRepeatCount();
        this.setDurationSecond = detail.getSetDurationSecond();
        this.setCount = detail.getSetCount();
        this.workoutOrder = detail.getWorkoutOrder();
        this.workout = new WorkoutResponse(detail.getWorkout());
        this.description = detail.getDescription();
        this.type = detail.getType();
        this.id = detail.getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActivityGroupType getType() {
        return type;
    }

    public void setType(ActivityGroupType type) {
        this.type = type;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Integer getSetDurationSecond() {
        return setDurationSecond;
    }

    public void setSetDurationSecond(Integer setDurationSecond) {
        this.setDurationSecond = setDurationSecond;
    }

    public Integer getSetCount() {
        return setCount;
    }

    public void setSetCount(Integer setCount) {
        this.setCount = setCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWorkoutOrder() {
        return workoutOrder;
    }

    public void setWorkoutOrder(Integer workoutOrder) {
        this.workoutOrder = workoutOrder;
    }

    public WorkoutResponse getWorkout() {
        return workout;
    }

    public void setWorkout(WorkoutResponse workout) {
        this.workout = workout;
    }
}
