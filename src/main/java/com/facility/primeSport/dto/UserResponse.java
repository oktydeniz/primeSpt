package com.facility.primeSport.dto;

import lombok.*;

public record UserResponse(
        Long id,
        String name,
        String email
) {
}
