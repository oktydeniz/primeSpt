package com.facility.primeSport.dto.user;

import com.facility.primeSport.enums.Gender;
import com.facility.primeSport.enums.permission.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAuthRegisterRequest {

    private String userName;

    private String email;

    private String password;

    private String phoneNumber;

    private Gender gender;

    private LocalDate birthDate;

    private Boolean isActiveMarketing;

    private Boolean isActiveAnalytics;

    private Boolean isActiveAdverting;

    private Long buildingId;

    private Role role;

}
