package com.example.erfan_adine_ptest.entity.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.erfan_adine_ptest.entity.security.Permission.*;


public enum Role {
    USER(Set.of()),
    STUDENT(Set.of(STUDENT_READ)),
    ADMIN(Set.of(STUDENT_WRITE, STUDENT_READ, ADMIN_WRITE, ADMIN_READ ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority() {
        Set<SimpleGrantedAuthority> authorities = getPermissions()
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermissionName()))
                .collect(Collectors.toSet());
        authorities.add((new SimpleGrantedAuthority("ROLE_"+this.name())));
        return authorities;
    }
}
