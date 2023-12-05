package com.facility.primeSport.entitiy.activity;

import com.facility.primeSport.View;
import com.facility.primeSport.enums.WorkoutLevel;
import com.facility.primeSport.entitiy.Building;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "public_activity_list")
@Getter
@Setter
public class PublicActivityList extends DateIDBaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", unique = true)
    @JsonView(View.Public.class)
    private User ownerId;

    @JsonView(View.Public.class)
    @Column(name = "workout_level")
    @Enumerated(EnumType.STRING)
    private WorkoutLevel workoutLevel;

    @JsonView(View.Public.class)
    @Column(name = "is_active")
    private boolean isActive;

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
    @Column(name = "target_Audience", length = 60)
    private String targetAudience;

    @JsonView(View.Public.class)
    @Column(name = "workout_type", length = 30)
    private String workoutType;
}
