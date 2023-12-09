package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "user_sport_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSportDetail extends DateIDBaseModel {

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private User coach;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "member_start_date")
    @JsonView(View.Public.class)
    private LocalDate memberStartDate;

    @Column(name = "member_end_date")
    @JsonView(View.Public.class)
    private LocalDate memberEndDate;

    @JoinColumn(name = "package_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BuildingPackage buildingPackage;


    public UserSportDetail(Building building, BuildingPackage _package, User user, User coach){
        this.building = building;
        this.buildingPackage = _package;
        this.user = user;
        this.memberStartDate = LocalDate.now();
        this.memberEndDate = LocalDate.now().plusMonths(buildingPackage.getPackageUsageRange());
        this.coach = coach;
    }

}
