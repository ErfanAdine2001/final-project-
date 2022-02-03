package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.entity.work.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ExperteRepository extends JpaRepository<SubService, Long> {

    @Query("select e from SubService e group by e.id")
    List<SubService> GroupById();
//    @Query("select e from SubServiceInDto e where e.id = ?1")
//    Optional<SubServiceInDto> findById(Long id) ;
//
//    void delete(Optional<SubServiceInDto> byId);
//
//    void update(Optional<SubServiceInDto> byId);
}
