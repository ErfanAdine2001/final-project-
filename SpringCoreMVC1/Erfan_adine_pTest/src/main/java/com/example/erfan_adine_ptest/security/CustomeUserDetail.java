package com.example.erfan_adine_ptest.security;

import com.example.erfan_adine_ptest.entity.user.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomeUserDetail implements UserDetails {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final Boolean isEnabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomeUserDetail(Admin admin) {
        this.firstName = admin.getFName();
        this.lastName = admin.getLName();
        this.password = admin.getPassword();
        this.isEnabled = admin.getIsEnable();
        this.username = admin.getUsername();
        this.authorities = admin.getAuthorities();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
