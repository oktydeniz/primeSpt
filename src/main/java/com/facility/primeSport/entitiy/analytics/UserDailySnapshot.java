package com.facility.primeSport.entitiy.analytics;

import com.facility.primeSport.View;

import com.facility.primeSport.enums.DegreeOfObesity;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "user_analytics_snapshot")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDailySnapshot extends DailyBaseModel {

    @Column(name = "snapshot_date")
    @JsonView(View.Public.class)
    private LocalDate snapshotDate;

    @Column(name = "body_fast_mass")
    @JsonView(View.Public.class)
    private Double bodyFatMass;

    @Column(name = "body_fast_mass_per")
    @JsonView(View.Public.class)
    private BigDecimal bodyFatMassPer;

    @Column(name = "fluid_mass")
    @JsonView(View.Public.class)
    private Double fluidMass;

    @Column(name = "fluid_mass_per")
    @JsonView(View.Public.class)
    private BigDecimal fluidMassPer;

    @Column(name = "muscle_mass")
    @JsonView(View.Public.class)
    private Double muscleMass;

    @Column(name = "muscle_mass_per")
    @JsonView(View.Public.class)
    private Double muscleMassPer;

    @Column(name = "visceral_fat")
    @JsonView(View.Public.class)
    private Double visceralFat;

    @Column(name = "protein_level")
    @JsonView(View.Public.class)
    private Double proteinLevel;

    @Column(name = "mineral_level")
    @JsonView(View.Public.class)
    private Double mineralLevel;

    @Column(name = "basal_metabolic_rate")
    @JsonView(View.Public.class)
    private Double basalMetabolicRate;

    @Column(name = "metabolic_age")
    @JsonView(View.Public.class)
    private Integer metabolicAge;

    @Column(name = "degree_of_obesity")
    @JsonView(View.Public.class)
    private BigDecimal degreeOfObesity;

    @Column(name = "degree_of_obesity_type")
    @JsonView(View.Public.class)
    @Enumerated(EnumType.STRING)
    private DegreeOfObesity degreeOfObesityType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "segment_id")
    @JsonView(View.Public.class)
    private SegmentAnalytics segmentAnalytics;
}
