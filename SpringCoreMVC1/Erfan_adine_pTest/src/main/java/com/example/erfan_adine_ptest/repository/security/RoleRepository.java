package com.example.erfan_adine_ptest.repository.security;

import com.example.erfan_adine_ptest.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);
}
