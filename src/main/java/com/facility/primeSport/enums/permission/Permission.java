package com.facility.primeSport.enums.permission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN("admin:admin"),
    ADMIN_CRUD("admin:crud"),
    ADMIN_READ("admin:read"),
    COACH_CRUD("coach:crud"),
    COACH_READ("coach:read"),
    USER_CRUD("user:crud"),
    USER_READ("user:read");

    @Getter
    private final String permission;
}
