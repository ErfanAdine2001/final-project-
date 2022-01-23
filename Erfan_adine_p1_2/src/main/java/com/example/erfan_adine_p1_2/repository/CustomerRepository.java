package com.example.erfan_adine_p1_2.repository;

import com.example.erfan_adine_p1_2.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
