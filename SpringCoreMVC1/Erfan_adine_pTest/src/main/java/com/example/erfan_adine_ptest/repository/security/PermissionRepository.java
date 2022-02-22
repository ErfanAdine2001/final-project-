package com.example.erfan_adine_ptest.repository.security;

import com.example.erfan_adine_ptest.entity.security.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission,Long> {


    Optional<Permission> findByPermissionName(String permissionName);
}
