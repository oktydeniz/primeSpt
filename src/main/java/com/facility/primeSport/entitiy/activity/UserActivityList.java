package com.facility.primeSport.entitiy.activity;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_activity_list")
public class UserActivityList extends DateIDBaseModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonView(View.Public.class)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    @JsonView(View.Public.class)
    private User coachId;

    @JsonView(View.Public.class)
    private String description;

    @JsonView(View.Public.class)
    private String name;

    @Column(name = "end_date")
    @JsonView(View.Public.class)
    private LocalDate endDate;

    @Column(name = "start_date")
    @JsonView(View.Public.class)
    private LocalDate startDate;

    @Column(name = "update_request_date")
    @JsonView(View.Public.class)
    private LocalDate requestToUpdateDate;

    @Column(name = "start_time")
    @JsonView(View.Public.class)
    private LocalTime startTime;

    @Column(name = "end_time")
    @JsonView(View.Public.class)
    private LocalTime endTime;

    @ElementCollection
    @CollectionTable(name = "program_days",
            joinColumns = @JoinColumn(name = "program_id"))
    @Column(name = "day")
    @JsonView(View.Public.class)
    private List<Integer> days;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "program_id")
    @JsonView(View.Public.class)
    private UserActivityProgram program;

}
