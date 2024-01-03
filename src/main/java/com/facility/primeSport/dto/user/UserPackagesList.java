package com.facility.primeSport.dto.user;

import com.facility.primeSport.dto.building.BuildingMemberDetailResponse;

import java.time.LocalDate;

public class UserPackagesList {

    private String coachName;
    private String profession;
    private String coachAvatar;
    private LocalDate packageEndDate;
    private LocalDate packageStartDate;

    public UserPackagesList(BuildingMemberDetailResponse response) {
        this.coachAvatar = response.getCoachAvatar();
        this.packageStartDate = response.getPackageStartDate();
        this.coachName = response.getCoachName();
        this.packageEndDate = response.getPackageEndDate();
        this.profession = response.getProfession();
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCoachAvatar() {
        return coachAvatar;
    }

    public void setCoachAvatar(String coachAvatar) {
        this.coachAvatar = coachAvatar;
    }

    public LocalDate getPackageEndDate() {
        return packageEndDate;
    }

    public void setPackageEndDate(LocalDate packageEndDate) {
        this.packageEndDate = packageEndDate;
    }

    public LocalDate getPackageStartDate() {
        return packageStartDate;
    }

    public void setPackageStartDate(LocalDate packageStartDate) {
        this.packageStartDate = packageStartDate;
    }
}
