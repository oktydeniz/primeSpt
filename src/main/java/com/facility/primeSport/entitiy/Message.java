package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;

import com.facility.primeSport.entitiy.activity.UserActivityList;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "message")
@Entity
public class Message extends DateIDBaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    @JsonView(View.Public.class)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    @JsonView(View.Public.class)
    private User receiver;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    @JsonView(View.Public.class)
    private UserActivityList activity;

    @Column(name = "context", length = 350)
    @JsonView(View.Public.class)
    private String context;

    @Column(name = "is_deleted")
    @JsonView(View.Public.class)
    private boolean isDeleted;


}
