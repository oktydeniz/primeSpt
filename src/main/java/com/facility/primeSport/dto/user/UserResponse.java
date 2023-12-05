package com.facility.primeSport.dto.user;

import com.facility.primeSport.entitiy.User;
import lombok.Data;

public record UserResponse(
        Long id,
        String name,
        String email
) {

}
