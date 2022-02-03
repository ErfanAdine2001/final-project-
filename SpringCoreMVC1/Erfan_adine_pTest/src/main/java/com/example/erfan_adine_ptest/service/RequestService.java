package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.product.message.Request;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.RequestRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService extends Common<Request, Long> {
    private final RequestRepository requestRepository;

    private Validation validation;

    @PostConstruct
    public void init() {
        setJpaRepository(requestRepository);
    }


    @Override
    public Request save(Request entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, RoleIsNullException, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.RequestServiceIsValid(entity))
            return super.save(entity);
        return null;
    }

    @Override
    public Request findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Request> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void update(Long id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(id);
    }
}
