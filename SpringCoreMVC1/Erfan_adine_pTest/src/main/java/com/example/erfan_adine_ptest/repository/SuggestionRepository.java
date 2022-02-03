package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    @Query("select e from Suggestion e group by e.id")
    List<Suggestion> GroupById();
}
