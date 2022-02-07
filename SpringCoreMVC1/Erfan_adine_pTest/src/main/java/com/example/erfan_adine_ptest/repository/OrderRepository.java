package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<MainOrder, Long> {

    @Query("select e from MainOrder e group by e.id")
    List<MainOrder> GroupById();


//    List<MainOrder> findAllByStatus();

    List<MainOrder> findAllByStatus();
}
