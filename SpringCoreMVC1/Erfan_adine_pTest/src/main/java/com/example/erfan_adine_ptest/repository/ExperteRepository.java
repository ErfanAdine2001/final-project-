package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.dto.out.work.SubServiceOutDto;
import com.example.erfan_adine_ptest.entity.work.SubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ExperteRepository extends JpaRepository<SubService, Long> {
//
//    @Modifying
//    @Query("select e from SubService e group by e.id")
//    List<SubService> GroupById();
//





//    @Query("select e from SubServiceInDto e where e.id = ?1")
//    Optional<SubServiceInDto> findById(Long id) ;
//
//    void delete(Optional<SubServiceInDto> byId);
//
//    void update(Optional<SubServiceInDto> byId);
}
