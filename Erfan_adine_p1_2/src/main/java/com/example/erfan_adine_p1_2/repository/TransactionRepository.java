package com.example.erfan_adine_p1_2.repository;

import com.example.erfan_adine_p1_2.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
