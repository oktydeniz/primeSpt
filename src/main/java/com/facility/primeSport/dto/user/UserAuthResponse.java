package com.facility.primeSport.dto.user;

import lombok.Data;

import java.util.List;

@Data
public class UserAuthResponse {

    private String userName;

    private String email;

    private String accessToken;

    private String  refreshToken;

    private List<String> roles;

    private String language;

    private String message;

}
