package com.facility.primeSport.entitiy;

import com.facility.primeSport.View;
import com.facility.primeSport.dto.building.PackageRequest;
import com.facility.primeSport.entitiy.base.DateIDBaseModel;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "building_package")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuildingPackage extends DateIDBaseModel {

    @Column(name = "package_name")
    @JsonView(View.Public.class)
    private String packageName;

    @Column(name = "price")
    @JsonView(View.Public.class)
    private BigDecimal price;

    @Column(name = "description")
    @JsonView(View.Public.class)
    private String description;

    @Column(name = "package_url")
    @JsonView(View.Public.class)
    private String packageUrl;

    @Column(name = "end_date")
    @JsonView(View.Public.class)
    private LocalDate endDate;

    @Column(name = "discount_rate")
    @JsonView(View.Public.class)
    private Integer discountRate;


    @Column(name = "package_usage_range", nullable = false)
    @JsonView(View.Public.class)
    private Integer packageUsageRange;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;


    public BuildingPackage(PackageRequest request){
        this.discountRate = request.discountRate();
        this.endDate = request.endDate();
        this.packageUrl = request.packageUrl();
        this.description = request.description();
        this.price = request.price();
        this.packageName = request.packageName();
        this.packageUsageRange = request.packageUsageRange();
    }
}
