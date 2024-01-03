package com.facility.primeSport.dto.user;

import com.facility.primeSport.entitiy.User;

public class OwnerUserDetail {

    private String userName;

    private String phoneNumber;

    private String avatarUrl;

    public OwnerUserDetail(User user) {
        this.userName = user.getUserName();
        this.phoneNumber = user.getPhoneNumber();
        this.avatarUrl = user.getAvatarUrl();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
