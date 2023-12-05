package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;

import com.facility.primeSport.dto.building.BuildingRequest;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "building")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Building extends DateIDBaseModel {

	@Serial
    private static final long serialVersionUID = 4301658769722202059L;

	@Column(name = "building_name", length = 60)
    @JsonView(View.Public.class)
    private String buildingName;

    @Column(name = "building_logo")
    @JsonView(View.Public.class)
    private String buildingLogoUrl;

    @Column(name = "building_facebook")
    @JsonView(View.Public.class)
    private String facebookUrl;

    @Column(name = "building_instagram")
    @JsonView(View.Public.class)
    private String instagramUrl;

    @Column(name = "building_X")
    @JsonView(View.Public.class)
    private String XUrl;

    @Column(name = "building_web_url")
    @JsonView(View.Public.class)
    private String buildingWebUrl;

    @Column(name = "latitude")
    @JsonView(View.Public.class)
    private Double latitude;

    @Column(name = "longitude")
    @JsonView(View.Public.class)
    private Double longitude;

    @Column(name = "building_desc", length = 350)
    @JsonView(View.Public.class)
    private String buildingDescription;

    @Column(name = "building_primary_number")
    @JsonView(View.Public.class)
    private String buildingPhoneNumber;

    @Column(name = "building_primary_number_sec")
    @JsonView(View.Public.class)
    private String buildingPhoneNumberSecond;

    @ManyToMany
    @JoinTable(
            name = "user_building",
            joinColumns = @JoinColumn(name = "building_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    public Building(BuildingRequest dto){
        this.buildingName = dto.getBuildingName();
        this.buildingLogoUrl = dto.getBuildingUrl();
        this.buildingDescription = dto.getBuildingDescription();
        this.facebookUrl = dto.getFacebookUrl();
        this.instagramUrl = dto.getInstagramUrl();
        this.XUrl = dto.getXUrl();
        this.longitude = dto.getLongitude();
        this.latitude = dto.getLatitude();
        this.buildingPhoneNumber = dto.getBuildingPhoneNumber();
        this.buildingPhoneNumberSecond = dto.getBuildingPhoneNumberSecond();
    }

}
