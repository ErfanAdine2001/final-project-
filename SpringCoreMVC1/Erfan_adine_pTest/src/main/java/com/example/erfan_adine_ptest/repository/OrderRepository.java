package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.entity.product.MainOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<MainOrder, Long> {

    @Query("select e from MainOrder e group by e.id")
    List<MainOrder> GroupById();


}
