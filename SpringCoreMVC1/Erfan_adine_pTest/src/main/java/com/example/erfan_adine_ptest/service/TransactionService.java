package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.Transaction;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.TransactionRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService extends Common<Transaction, Long> {
    private final TransactionRepository transactionRepository;

    private Validation validation;

    @PostConstruct
    public void init() {
        setJpaRepository(transactionRepository);
    }

    @Override
    public Transaction save(Transaction entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, RoleIsNullException, SuggestionOfPriceIsNullException, OrderOfTransactionIsNullExeption {
        if (validation.TransactionalIsVAlid(entity))
            return super.save(entity);
        return null;
    }

    @Override
    public Transaction findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Transaction> findAll() {
        return super.findAll();
    }

    @Override
    public void update(Long id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(id);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
