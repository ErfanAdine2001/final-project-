package com.example.erfan_adine_ptest.entity.security;

import com.example.erfan_adine_ptest.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String roleName;

    @ManyToMany
    private Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

//    @ManyToOne
//    private User user;

    public Set<SimpleGrantedAuthority> getAuthority() {
        Set<SimpleGrantedAuthority> authorities = getPermissions()
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermissionName()))
                .collect(Collectors.toSet());
        authorities.add((new SimpleGrantedAuthority("ROLE_"+this.roleName)));
        return authorities;
    }

}
