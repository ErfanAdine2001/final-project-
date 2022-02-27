package com.example.erfan_adine_ptest.dto.out.security;

import com.example.erfan_adine_ptest.entity.security.Permission;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleOutDto {

    private Long id;

    private String roleName;

    private Set<Permission> permissions;

    private Admin admin;
}
