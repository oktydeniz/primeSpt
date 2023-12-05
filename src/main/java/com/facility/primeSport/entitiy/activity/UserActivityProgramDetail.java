package com.facility.primeSport.entitiy.activity;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.Workout;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_activity_program_detail")
public class UserActivityProgramDetail extends DateIDBaseModel {

    @JoinColumn(name = "program_id")
    @JsonView(View.Public.class)
    @ManyToOne
    private UserActivityProgram activityProgram;

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
