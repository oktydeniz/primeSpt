package com.facility.primeSport.entitiy.activity;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.facility.primeSport.enums.ActivityGroupType;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "public_activity_workout_list_detail")
@Getter
@Setter
public class PublicActivityWorkoutListDetail extends DateIDBaseModel {

    @JoinColumn(name = "program_id")
    @JsonView(View.Public.class)
    @ManyToOne
    private PublicActivityWorkoutList publicActivityList;

    @Column(name = "repeat_count")
    @JsonView(View.Public.class)
    private Integer repeatCount;

    @Column(name = "set_duration_second")
    @JsonView(View.Public.class)
    private Integer setDurationSecond;

    @Column(name = "set_count")
    @JsonView(View.Public.class)
    private Integer setCount;

    @JsonView(View.Public.class)
    private String description;

    @Column(name = "workout_order")
    @JsonView(View.Public.class)
    private Integer workoutOrder;

    @JoinColumn(name = "workout_id")
    @JsonView(View.Public.class)
    @ManyToOne
    private Workout workout;

    @JsonView(View.Public.class)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "activity_type")
    private ActivityGroupType type;

}
