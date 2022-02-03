package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.exception.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class Common<T, ID> {

    private JpaRepository<T, ID> jpaRepository;

    @Transactional
    public void setJpaRepository(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;

    }

    @Transactional
    public T save(T entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, RoleIsNullException, SuggestionOfPriceIsNullException, OrderOfTransactionIsNullExeption {
        return jpaRepository.save(entity);
    }

    @Transactional
    public T findById(ID id) {
        return (T) jpaRepository.findById(id).get();
    }

    @Transactional
    public void delete(ID id) {
        T entity = findById(id);
        jpaRepository.delete(entity);
    }

    @Transactional
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Transactional
    public void update(ID id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        save(findById(id));
    }


}
