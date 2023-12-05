package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sport")
public class Sport extends DateIDBaseModel {

    @JsonView(View.Public.class)
    private String name;

    @Column(name = "logo_url")
    @JsonView(View.Public.class)
    private String logoUrl;

}
