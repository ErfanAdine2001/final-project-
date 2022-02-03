package com.example.erfan_adine_ptest.repository;

import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {



    @Query("select e from User e group by e.id")
    List<User> GroupById();

    @Modifying
    @Query("update User u set u.password=:password where u.id =:id ")
    void removeById(Long id, String password);


    //TODO f2-3
    @Query("select s from Suggestion s group by s.id")
    Suggestion GroupSuggestionById();


    //TODO f2-4
    @Modifying
    @Query("select s from Suggestion s where s.id=:id")
    Worker registerOfWorkerById(Long id);






    //TODO check and make methods in Service layer

}



