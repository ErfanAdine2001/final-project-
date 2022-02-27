package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasePersonRepo extends JpaRepository<BasePerson, Long> {
    Optional<BasePerson> findByUsername(String username);
}
