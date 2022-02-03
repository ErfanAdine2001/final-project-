package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.entity.product.Comment;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.CommentRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService extends Common<Comment, Long> {
    private final CommentRepository commentRepository;

    private Validation validation;

    @PostConstruct
    public void init() {
        setJpaRepository(commentRepository);
    }

    @Transactional
    @Override
    public Comment findById(Long id) {
        return super.findById(id);
    }

    @Transactional
    @Override
    public List<Comment> findAll() {
        return super.findAll();
    }

    @Transactional
    @Override
    public Comment save(Comment entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.commentIsValid(entity.getDescription())) {
            return super.save(entity);
        }
        return null;
    }

    @Transactional
    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }

    @Transactional
    @Override
    public void update(Long aLong) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(aLong);
    }

    //    public List<Object[]> groupBy(Long id){
//        return commentRepository.gropById(id);
//    }
//
//    @Transactional
//    public List<CommentInDto> gropById() {
//        return commentRepository.GroupById();
//    }


}
