package com.facility.primeSport.dto.user;

import com.facility.primeSport.entitiy.User;

import java.time.LocalDate;

public class OwnerUserDetail {

    private String userName;

    private String phoneNumber;

    private String avatarUrl;

    private CoachDetailResponse coach;

    private String packageName;

    private LocalDate memberEndDate;

    public OwnerUserDetail(User user){
        this.memberEndDate = user.getMemberEndDate();
        this.userName = user.getUserName();
        this.phoneNumber = user.getPhoneNumber();
        this.packageName = user.getBuildingPackage().getPackageName();
        this.avatarUrl = user.getAvatarUrl();
        this.coach = new CoachDetailResponse(user.getCoach());
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public CoachDetailResponse getCoach() {
        return coach;
    }

    public void setCoach(CoachDetailResponse coach) {
        this.coach = coach;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public LocalDate getMemberEndDate() {
        return memberEndDate;
    }

    public void setMemberEndDate(LocalDate memberEndDate) {
        this.memberEndDate = memberEndDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
