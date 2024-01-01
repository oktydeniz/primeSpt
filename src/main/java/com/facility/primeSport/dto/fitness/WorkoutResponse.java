package com.facility.primeSport.dto.fitness;

import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.enums.WorkoutLevel;

public class WorkoutResponse {

    private String workoutName;
    private String workoutImage;
    private String workoutVideoUrl;
    private String description;
    private String bodyPart;
    private String equipment;
    private String targetMuscle;
    private WorkoutLevel level;


    public WorkoutResponse(Workout workout){
        this.bodyPart = workout.getBodyPart();
        this.description = workout.getDescription();
        this.workoutName = workout.getWorkoutName();
        this.workoutImage = workout.getWorkoutImage();
        this.equipment = workout.getEquipment();
        this.targetMuscle = workout.getTargetMuscle();
        this.workoutVideoUrl = workout.getWorkoutVideoUrl();
        this.level = workout.getLevel();
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutImage() {
        return workoutImage;
    }

    public void setWorkoutImage(String workoutImage) {
        this.workoutImage = workoutImage;
    }

    public String getWorkoutVideoUrl() {
        return workoutVideoUrl;
    }

    public void setWorkoutVideoUrl(String workoutVideoUrl) {
        this.workoutVideoUrl = workoutVideoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public WorkoutLevel getLevel() {
        return level;
    }

    public void setLevel(WorkoutLevel level) {
        this.level = level;
    }
}
