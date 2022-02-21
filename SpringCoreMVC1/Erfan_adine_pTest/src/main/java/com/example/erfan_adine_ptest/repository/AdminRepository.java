package com.example.erfan_adine_ptest.repository;


import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
//import javax.persistence.Query;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Map;


public interface AdminRepository extends JpaRepository<Admin, Long>, JpaSpecificationExecutor<Admin> {

    // -----------------------------------------
    /**
     * user and worker ->update
     *
     * @param id
     * @param password
     */
    @Modifying
    @Query("update User u set u.password=:password where u.id =:id ")
    void updatUserById(Long id, String password);

    @Modifying
    @Query("update Worker w set w.password=:password where w.id =:id ")
    void updateWorkerById(Long id, String password);
//    //TODO make 2 and 3 method in Service AdminInDto?

    /**
     * UserInDto and worker  -> delete
     *
     * @param id
     * @param password
     */
    @Modifying
    @Query("delete from User u where u.id=:id and u.password=:password")
    void removeUserById(Long id, String password);

    @Modifying
    @Query("delete from Worker w where w.id=:id and w.password=:password ")
    void removeWorkerById(Long id, String password);


    //------------------------------------------------------filter of users
    // TODO f1 ------------------ > 1-3  service
    @Query("select u from User u where u.fName=:firstName and u.lName=:lastName")
    User findUsersByfNameAndLName(String firstName, String lastName);
//    UserInDto findUsersByIdAndRole(Long id, List<RoleInDto> role);

    @Modifying
    @Query("select w from Worker w where w.fName=:firstName")
    List<Worker> findWorkerByName(String firstName);

    @Modifying
    @Query("select u from User u where u.fName=:firstName and u.lName=:lastName")
    List<User> findUsersByfName(String firstName);
//
    //-------------------------------------------------------

    //-------------------------------------------------------adding new  mainService and  expert
    //TODO f1 -------------------> 1-4 repository is null
    //  this part dont need to repository

    //--------------------------------------------
    //todo f1 ----------------------> 1-5 Repository need
    @Modifying
    @Query("select w from Worker w where w.fName=:firstName and w.lName=:lastName")
    Worker findWorkerByfNameAndLName(String firstName, String lastName);


    //------------------------------------------------
    @Modifying
    @Query("select u from User u where u.fName=:name")
    List<User> findByFName(String name);


//    List<MainOrder> searchBydate();

//     Admin findByPasswordAndAndFName(){
//
//    }

//    @Query("select e from SubServiceInDto e where e.name=:Name and ")
//    @Query("SELECT SubServiceInDto.id  FROM SubServiceInDto INNER JOIN worker_duty  INNER JOIN WorkerInDto.id" +
//            " ON SubServiceInDto.id=worker_duty.worker_id and WorkerInDto.id=worker_duty.duty_id " +
//            "where SubServiceInDto .name=:name  and WorkerInDto .id=:idWorker")
//    SubServiceInDto findExpertByNameAndIdOfWorker(String name,Long idWorker);
//


    //***********************************************
    //***********************************************



}
