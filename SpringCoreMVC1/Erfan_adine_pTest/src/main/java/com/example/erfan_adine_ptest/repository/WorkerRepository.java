package com.example.erfan_adine_ptest.repository;


import com.example.erfan_adine_ptest.entity.product.message.BaseMessageStatus;
import com.example.erfan_adine_ptest.entity.user.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WorkerRepository extends JpaRepository<Worker, Long> {

    //TODO f2-1
    @Query("update Request r set r.status=:baseMessageStatus")
    void ConfirmationOfOrder(BaseMessageStatus baseMessageStatus);


    @Query("select w from Worker w where w.fName=:firstName")
    Worker findByFirstNameName(String firstName);


}
