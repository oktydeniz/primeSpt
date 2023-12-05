package com.facility.primeSport.enums.permission;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(Permission.ADMIN)), // us
    B_OWNER(Set.of(Permission.ADMIN_CRUD, Permission.COACH_CRUD)), // owner any building
    B_COACH(Set.of(Permission.COACH_CRUD)), // coach in a building
    B_USER(Set.of(Permission.USER_READ)), // user who work out in a building with or without coach
    COACH(Set.of(Permission.COACH_CRUD, Permission.USER_CRUD)), // user who coach but not in a building
    USER(Set.of(Permission.USER_CRUD)); // user who work out by it-selves

    @Getter
    private final Set<Permission> permissionSet;

    public List<SimpleGrantedAuthority> authorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = permissionSet.stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toList());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return grantedAuthorities;
    }
}
