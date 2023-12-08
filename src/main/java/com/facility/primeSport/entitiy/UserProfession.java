package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profession")
public class UserProfession extends DateIDBaseModel {

    @Column(name = "profession_name")
    @JsonView(View.Public.class)
    private String professionName;

    @Column(name = "profession_img")
    @JsonView(View.Public.class)
    private String professionImg;


}
