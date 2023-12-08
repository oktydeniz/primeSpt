package com.facility.primeSport.dto.building;

import com.facility.primeSport.entitiy.BuildingPackage;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PackageDetailResponse {

    private String packageName;

    private BigDecimal price;

    private String description;

    private String packageUrl;

    private LocalDate endDate;

    private Integer discountRate;

    private Integer packageUsageRange;

    public PackageDetailResponse(BuildingPackage buildingPackage){
        this.discountRate = buildingPackage.getDiscountRate();
        this.endDate = buildingPackage.getEndDate();
        this.packageUrl = buildingPackage.getPackageUrl();
        this.description = buildingPackage.getDescription();
        this.price = buildingPackage.getPrice();
        this.packageName = buildingPackage.getPackageName();
        this.packageUsageRange = buildingPackage.getPackageUsageRange();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackageUrl() {
        return packageUrl;
    }

    public void setPackageUrl(String packageUrl) {
        this.packageUrl = packageUrl;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getPackageUsageRange() {
        return packageUsageRange;
    }

    public void setPackageUsageRange(Integer packageUsageRange) {
        this.packageUsageRange = packageUsageRange;
    }
}
