package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.SuggestionRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionService extends Common<Suggestion, Long> {
    private final SuggestionRepository suggestionRepository;

    private Validation validation;

    @PostConstruct
    public void init() {
        setJpaRepository(suggestionRepository);
    }


    @Transactional
    @Override
    public Suggestion save(Suggestion entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, SuggestionOfPriceIsNullException, OrderOfTransactionIsNullExeption {
        if (validation.SuggestionIsValid(entity))
            return super.save(entity);
        return null;
    }

    @Transactional
    @Override
    public Suggestion findById(Long aLong) {
        return super.findById(aLong);
    }


    @Transactional
    @Override
    public List<Suggestion> findAll() {
        return super.findAll();
    }

    @Transactional
    @Override
    public void update(Long aLong) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(aLong);
    }

    @Transactional
    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }
}
