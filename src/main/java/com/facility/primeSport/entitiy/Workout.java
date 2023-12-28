package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.activity.PublicActivityWorkoutListDetail;
import com.facility.primeSport.enums.WorkoutLevel;
import com.facility.primeSport.entitiy.Sport;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workout")
@Getter
@Setter
public class Workout extends DateIDBaseModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_id")
    @JsonView(View.Public.class)
    private Sport sport;

    @JsonView(View.Public.class)
    @Column(name = "workout_name")
    private String workoutName;

    @JsonView(View.Public.class)
    @Column(name = "workout_image")
    private String workoutImage;

    @JsonView(View.Public.class)
    @Column(name = "workout_video_url")
    private String workoutVideoUrl;

    @JsonView(View.Public.class)
    private String description;

    @JsonView(View.Public.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "workout_level")
    private WorkoutLevel level;

    @JsonView(View.Public.class)
    @Column(name = "body_part")
    private String bodyPart;

    @JsonView(View.Public.class)
    @Column(name = "equipment", length = 100)
    private String equipment;

    @JsonView(View.Public.class)
    @Column(name = "target_muscle", length = 100)
    private String targetMuscle;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "public_activity_workout_list_detail_id")
    private PublicActivityWorkoutListDetail publicActivityListDetail;
}
