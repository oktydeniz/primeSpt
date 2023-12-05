package com.facility.primeSport.entitiy.activity;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "public_activity_program_detail")
@Getter
@Setter
public class PublicActivityProgramDetail extends DateIDBaseModel {

    @JoinColumn(name = "program_id")
    @JsonView(View.Public.class)
    @ManyToOne
    private PublicActivityList publicActivityList;

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

    @JsonView(View.Public.class)
    @JoinColumn(name = "workout_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Workout workout;

}
