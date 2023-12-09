package com.facility.primeSport.dto.building;

import com.facility.primeSport.entitiy.UserSportDetail;

import java.time.LocalDate;

public class BuildingMemberDetailResponse {

    private LocalDate packageEndDate;
    private LocalDate packageStartDate;
    private String userName;
    private String phoneNumber;
    private String userAvatar;
    private Long userId;
    private String coachName;
    private String profession;
    private String coachAvatar;
    private String level;


    public BuildingMemberDetailResponse(UserSportDetail detail){
        this.userId = detail.getUser().getId();
        this.userName = detail.getUser().getUserName();
        this.phoneNumber = detail.getUser().getPhoneNumber();
        this.userAvatar = detail.getUser().getAvatarUrl();
        this.coachAvatar = detail.getCoach().getAvatarUrl();
        this.coachName = detail.getCoach().getUserName();
        this.packageEndDate = detail.getMemberEndDate();
        this.profession = detail.getCoach().getProfession().getProfessionName();
        this.level = detail.getUser().getUserLevel();
        this.packageStartDate = detail.getMemberStartDate();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
