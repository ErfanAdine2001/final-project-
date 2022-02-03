package com.example.erfan_adine_ptest.repository;


import com.example.erfan_adine_ptest.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    //    @Query("select w from TransactionInDto w where w.id=:id group by w.id")
//    List<TransactionInDto> GroupById(Long id);
    @Query("select e from Transaction e group by e.id")
    List<Transaction> GroupById();
}
