package com.example.erfan_adine_ptest.entity.core;

import com.example.erfan_adine_ptest.entity.security.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//@MappedSuperclass
public class BasePerson extends BaseEntity implements UserDetails {


    private String fName;

    private String lName;

    private String email;

    private String password;

    //--------------------------------
    private String username;

    private Boolean isEnable;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @Override
    public Set<SimpleGrantedAuthority> getAuthorities() {
        return roles.stream().flatMap(r -> r.getAuthority().stream())
                .collect(Collectors.toSet());
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
        return isEnable;
    }


}
