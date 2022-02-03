package com.example.erfan_adine_ptest.repository;



import com.example.erfan_adine_ptest.entity.product.message.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RequestRepository extends JpaRepository<Request, Long> {
//    @Query("select w from RequestInDto w where w.id=:id group by w.id")
//    List<RequestInDto> GroupById(Long id);

    @Query("select e from Request e group by e.id")
    List<Request> GroupById();

}
