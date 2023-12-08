package com.facility.primeSport.dto.user;


import com.facility.primeSport.dto.building.UserBuildingInfoResponse;
import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailResponse {

    private String userName;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private String userLevel;
    private String userAvatarUrl;
    private CoachDetailResponse coach;
    private LocalDate memberStartDate;
    private LocalDate memberEndDate;
    private String buildingPackage;
    private List<UserBuildingInfoResponse> buildingSet;
    private Boolean isActiveAdverting;
    private Boolean isActiveAnalytics;
    private Boolean isActiveMarketing;

    public UserDetailResponse(User user){
        this.gender = user.getGender();
        this.userLevel = user.getUserLevel();
        this.userName = user.getUserName();
        this.userAvatarUrl = user.getAvatarUrl();
        this.phoneNumber = user.getPhoneNumber();
        this.memberEndDate = user.getMemberEndDate();
        this.memberStartDate = user.getMemberStartDate();
        this.isActiveAdverting = user.getIsActiveAdverting();
        this.isActiveAnalytics = user.getIsActiveAnalytics();
        this.isActiveMarketing = user.getIsActiveMarketing();
        this.coach = new CoachDetailResponse(user);
        this.buildingPackage = user.getBuildingPackage().getPackageName();
        this.buildingSet = user.getBuildings().stream().map(UserBuildingInfoResponse::new).collect(Collectors.toList());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public CoachDetailResponse getCoach() {
        return coach;
    }

    public void setCoach(CoachDetailResponse coach) {
        this.coach = coach;
    }

    public LocalDate getMemberStartDate() {
        return memberStartDate;
    }

    public void setMemberStartDate(LocalDate memberStartDate) {
        this.memberStartDate = memberStartDate;
    }

    public LocalDate getMemberEndDate() {
        return memberEndDate;
    }

    public void setMemberEndDate(LocalDate memberEndDate) {
        this.memberEndDate = memberEndDate;
    }

    public String getBuildingPackage() {
        return buildingPackage;
    }

    public void setBuildingPackage(String buildingPackage) {
        this.buildingPackage = buildingPackage;
    }

    public List<UserBuildingInfoResponse> getBuildingSet() {
        return buildingSet;
    }

    public void setBuildingSet(List<UserBuildingInfoResponse> buildingSet) {
        this.buildingSet = buildingSet;
    }

    public Boolean getActiveAdverting() {
        return isActiveAdverting;
    }

    public void setActiveAdverting(Boolean activeAdverting) {
        isActiveAdverting = activeAdverting;
    }

    public Boolean getActiveAnalytics() {
        return isActiveAnalytics;
    }

    public void setActiveAnalytics(Boolean activeAnalytics) {
        isActiveAnalytics = activeAnalytics;
    }

    public Boolean getActiveMarketing() {
        return isActiveMarketing;
    }

    public void setActiveMarketing(Boolean activeMarketing) {
        isActiveMarketing = activeMarketing;
    }
}
