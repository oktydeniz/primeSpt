package com.facility.primeSport.entitiy.activity;

import com.facility.primeSport.View;
import com.facility.primeSport.dto.fitness.CreateActivityRequest;
import com.facility.primeSport.entitiy.fitness.ActivityType;
import com.facility.primeSport.enums.WorkoutLevel;
import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "public_activity_workout_list")
@Getter
@Setter
public class PublicActivityWorkoutList extends DateIDBaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonView(View.Public.class)
    private User ownerId;

    @JsonView(View.Public.class)
    @Column(name = "workout_level")
    @Enumerated(EnumType.ORDINAL)
    private WorkoutLevel workoutLevel;

    @JsonView(View.Public.class)
    @Column(name = "is_private")
    private boolean isPrivate;

    @JsonView(View.Public.class)
    @Column(name = "is_Deleted")
    private boolean isDeleted;

    @JsonView(View.Public.class)
    @Column(name = "image_url")
    private String imageUrl;

    @JsonView(View.Public.class)
    @Column(name = "count_of_clicked")
    private Integer countOfClicked;

    @JsonView(View.Public.class)
    @Column(name = "building_id")
    private Building building;

    @JsonView(View.Public.class)
    @Column(name = "rate")
    private Double rate;

    @JsonView(View.Public.class)
    @Column(name = "name", length = 120)
    private String name;

    @JsonView(View.Public.class)
    @Column(name = "description", length = 200)
    private String description;

    @JsonView(View.Public.class)
    @JoinColumn(name = "activity_type_id")
    @ManyToOne
    private ActivityType activityType;


    public PublicActivityWorkoutList(CreateActivityRequest request){
        this.description = request.description();
        this.name = request.name();
        this.imageUrl = request.imageUrl();
        this.workoutLevel = getLevel(request.workoutLevel());
        this.rate = 0.0;
        this.isDeleted = false;
        this.isPrivate = request.isPrivate();
        this.countOfClicked = 0;
    }

    private WorkoutLevel getLevel(Integer integer) {
        switch (integer){
            case 101 -> {
                return WorkoutLevel.BEGINNER;
            }
            case 102 -> {
                return WorkoutLevel.INTERMEDIATE;
            }
            case 103 -> {
                return WorkoutLevel.ADVANCED;
            }
            case 104 -> {
                return WorkoutLevel.SPECIFIC;
            }
        }
        return WorkoutLevel.BEGINNER;
    }
}
