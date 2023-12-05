package com.facility.primeSport.dto;

import com.facility.primeSport.enums.Gender;
import com.facility.primeSport.enums.permission.Role;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String userName;

    private String email;

    private String phoneNumber;

    private Gender gender;

    private Role role;

}
