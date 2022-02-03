package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.entity.work.MainService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DutyRepository extends JpaRepository<MainService, Long> {

    @Query("select e from MainService e group by e.id")
    List<MainService> GroupById();


    //-----------------------------------------------
    //TODO f1 -------------------> 1-5 repository
    void removeById(Long id);
    //-----------------------------------------------


//
//    @Query("select d from MainServiceInDto d where d.name=:name")
//    MainServiceInDto findByName(String name);
//

    MainService findByName(String name);

//     @Query("select d from MainServiceInDto d where d.id = ?1")
//     Optional<MainServiceInDto> findById(Long id) ;
//
//
//     void delete(Optional<MainServiceInDto> byId);
//
//     void update(Optional<MainServiceInDto> byId);

}
