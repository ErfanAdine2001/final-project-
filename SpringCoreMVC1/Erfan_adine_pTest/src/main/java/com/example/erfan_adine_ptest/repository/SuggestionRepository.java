package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.product.message.SuggestionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

   SuggestionStatus sss = null;


    @Modifying
    @Query("select e from Suggestion e group by e.id")
    List<Suggestion> GroupById();


    @Modifying
    @Query("select s from Suggestion s where s.suggestionStatus=:status")
    Page<WorkerOrUserSerchOutDto> findAllBystatusOrder(Pageable pageable , SuggestionStatus status);
}
