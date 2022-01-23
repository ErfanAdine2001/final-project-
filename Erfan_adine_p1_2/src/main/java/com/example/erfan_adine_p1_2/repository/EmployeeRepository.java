package com.example.erfan_adine_p1_2.repository;

import com.example.erfan_adine_p1_2.entity.user.Employee;
import com.example.erfan_adine_p1_2.entity.user.MainUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
