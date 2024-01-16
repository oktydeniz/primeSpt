package com.facility.primeSport.entitiy.analytics;

import com.facility.primeSport.View;

import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@MappedSuperclass
public class DailyBaseModel extends DateIDBaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonView(View.Public.class)
    @Getter
    @Setter
    private User user;

    @JsonView(View.Public.class)
    @Getter
    @Setter
    private Integer calories;

    @JsonView(View.Public.class)
    @Getter
    @Setter
    private Double distance;

    @Column(name = "stress_level")
    @JsonView(View.Public.class)
    @Getter
    @Setter
    private BigDecimal stressLevel;

    @JsonView(View.Public.class)
    @Getter
    @Setter
    private Integer steps;

    @Column(name = "sleep_time")
    @JsonView(View.Public.class)
    @Getter
    @Setter
    private Integer sleepTime;

    @JsonView(View.Public.class)
    @Getter
    @Setter
    private Double weight;

    @JsonView(View.Public.class)
    @Getter
    @Setter
    private Double height;

    @JsonView(View.Public.class)
    @Getter
    @Setter
    @Column(name = "body_mass_index")
    private Double bms;

    @JsonView(View.Public.class)
    @Getter
    @Setter
    @Column(name = "body_mass_index_per")
    private BigDecimal bmsPer;
}
