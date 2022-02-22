package com.example.erfan_adine_ptest.entity.user;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.security.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Admin extends BasePerson {

    private String username;

    private Boolean isEnable;


    @ElementCollection(targetClass = Role.class , fetch = FetchType.EAGER )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();


    public Set<SimpleGrantedAuthority> getAuthorities() {
        return roles.stream().flatMap(r -> r.getAuthority().stream())
                .collect(Collectors.toSet());
    }
    //TODO search for syntax : Auto query generate jpa repository
}
