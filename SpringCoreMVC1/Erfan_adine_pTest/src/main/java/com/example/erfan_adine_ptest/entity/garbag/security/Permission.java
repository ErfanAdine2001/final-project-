package com.example.erfan_adine_ptest.entity.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Permission {
    @Id
    @GeneratedValue
    private Long id;
    private String permissionName;

//    @ManyToMany
//    private Set<Role> role;

    public String getPermissionName() {
        return permissionName;
    }
}
