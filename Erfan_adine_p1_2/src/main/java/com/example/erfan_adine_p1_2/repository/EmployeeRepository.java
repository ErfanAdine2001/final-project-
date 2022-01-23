package com.example.erfan_adine_p1_2.repository;

import com.example.erfan_adine_p1_2.entity.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
