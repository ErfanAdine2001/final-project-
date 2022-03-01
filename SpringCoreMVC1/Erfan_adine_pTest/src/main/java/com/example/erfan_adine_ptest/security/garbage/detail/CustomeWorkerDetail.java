package com.example.erfan_adine_ptest.security.detail;

import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.Worker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomeWorkerDetail implements UserDetails {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final Boolean isEnabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomeWorkerDetail(Worker worker) {
        this.firstName = worker.getFName();
        this.lastName = worker.getLName();
        this.password = worker.getPassword();
        this.isEnabled = worker.getIsEnable();
        this.username = worker.getUsername();
        this.authorities = worker.getAuthorities();
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
