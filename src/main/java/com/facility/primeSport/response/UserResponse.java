package com.facility.primeSport.response;

import lombok.*;

public record UserResponse(
    Long id,
    String name,
    String email
){}
