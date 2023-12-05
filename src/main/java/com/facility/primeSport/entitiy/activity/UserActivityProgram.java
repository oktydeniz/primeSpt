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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_activity_program")
public class UserActivityProgram extends DateIDBaseModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonView(View.Public.class)
    private User owner;

    @JsonView(View.Public.class)
    private String name;

}
