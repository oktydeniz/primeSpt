package com.facility.primeSport.entitiy.analytics;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "segment_analytics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SegmentAnalytics extends DateIDBaseModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonView(View.Public.class)
    private User user;

    @Column(name = "leg_muscle_right")
    @JsonView(View.Public.class)
    private Double legMuscleRight;

    @Column(name = "leg_muscle_left")
    @JsonView(View.Public.class)
    private Double legMuscleLeft;

    @Column(name = "leg_fat_right")
    @JsonView(View.Public.class)
    private BigDecimal legFatRight;

    @Column(name = "leg_fat_left")
    @JsonView(View.Public.class)
    private BigDecimal legFatLeft;

    @Column(name = "arm_muscle_right")
    @JsonView(View.Public.class)
    private Double armMuscleRight;

    @Column(name = "arm_muscle_left")
    @JsonView(View.Public.class)
    private Double armMuscleLeft;

    @Column(name = "arm_fat_right")
    @JsonView(View.Public.class)
    private BigDecimal armFatRight;

    @Column(name = "arm_fat_left")
    @JsonView(View.Public.class)
    private BigDecimal armFatLeft;

    @Column(name = "upper_body_muscle_left")
    @JsonView(View.Public.class)
    private Double upperBodyMuscleLeft;

    @Column(name = "upper_body_fat_right")
    @JsonView(View.Public.class)
    private BigDecimal upperBodyFatRight;

}
