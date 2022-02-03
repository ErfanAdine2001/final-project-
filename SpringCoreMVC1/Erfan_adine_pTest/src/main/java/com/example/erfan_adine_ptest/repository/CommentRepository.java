package com.example.erfan_adine_ptest.repository;


import com.example.erfan_adine_ptest.entity.product.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select e from Comment e group by e.id")
    List<Comment> GroupById();
}
