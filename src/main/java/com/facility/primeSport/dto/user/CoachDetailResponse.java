package com.facility.primeSport.dto.user;


import com.facility.primeSport.entitiy.User;
import com.facility.primeSport.entitiy.UserProfession;

public class CoachDetailResponse {
    private String userName;
    private String avatarUrl;
    private UserProfession profession;


    public CoachDetailResponse(User user){
        if (user!= null){
            this.userName = user.getUserName();
            this.avatarUrl = user.getAvatarUrl();
            this.profession = user.getProfession();
        } else {
            this.userName = "";
            this.avatarUrl = "";
            this.profession = null;
        }

    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public UserProfession getProfession() {
        return profession;
    }

    public void setProfession(UserProfession profession) {
        this.profession = profession;
    }
}
