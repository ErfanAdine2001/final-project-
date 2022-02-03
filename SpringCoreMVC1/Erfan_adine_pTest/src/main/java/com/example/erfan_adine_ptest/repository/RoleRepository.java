package com.example.erfan_adine_ptest.repository;


import com.example.erfan_adine_ptest.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query("select e from Role e group by e.id")
    List<Role> GroupById();


}
