package com.facility.primeSport.dto.building;

import com.facility.primeSport.entitiy.UserSportDetail;

import java.time.LocalDate;

public class BuildingMembersResponse {

    //user - pck
    private LocalDate packageEndDate;

    //user
    private String userName;
    private String phoneNumber;
    private String userAvatar;
    private Long userId;

    // coach
    private String coachName;
    private String profession;
    private String coachAvatar;

    public BuildingMembersResponse(UserSportDetail userSportDetail) {
        this.userId = userSportDetail.getUser().getId();
        this.userName = userSportDetail.getUser().getUserName();
        this.phoneNumber = userSportDetail.getUser().getPhoneNumber();
        this.userAvatar = userSportDetail.getUser().getAvatarUrl();
        this.coachAvatar = userSportDetail.getCoach().getAvatarUrl();
        this.coachName = userSportDetail.getCoach().getUserName();
        this.packageEndDate = userSportDetail.getMemberEndDate();
        this.profession = userSportDetail.getCoach().getProfession().getProfessionName();
    }


    public LocalDate getPackageEndDate() {
        return packageEndDate;
    }

    public void setPackageEndDate(LocalDate packageEndDate) {
        this.packageEndDate = packageEndDate;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
