package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.dto.in.product.CommentInDto;
import com.example.erfan_adine_ptest.entity.product.Comment;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Transactional
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Transactional
    public Comment save(CommentInDto commentInDto) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        Comment comment = new Comment();
        comment.setPoints(commentInDto.getPoints());
        comment.setDescription(commentInDto.getDescription());
        comment.setOrder(commentInDto.getOrder());
        comment.setCreatedTime(new Date());
        comment.setUpdatedTime(new Date());
        comment.setSender(commentInDto.getSender());
        comment.setSubService(commentInDto.getSubService());
       return commentRepository.save(comment);
    }

    @Transactional
    public void delete(Long id) {
        commentRepository.delete(findById(id));
    }

    @Transactional
    public void update(Long id,String Description, Integer point) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {

        Comment comment = findById(id);
        comment.setDescription(Description);
        comment.setPoints(point);

        commentRepository.save(comment);
    }


}
