package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.Transaction;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;


    @Transactional
    public Transaction save(Transaction entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, RoleIsNullException, SuggestionOfPriceIsNullException, OrderOfTransactionIsNullExeption {
        if (validation.TransactionalIsVAlid(entity))
            return super.save(entity);
        return null;
    }

    @Transactional
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Transactional
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Transactional
    public void updateAmountOfTransaction(Long id, BigDecimal amount) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        Transaction t = findById(id);
        t.setAmount(amount);
        transactionRepository.save(t);
    }

    @Transactional
    public void delete(Long id) {
        transactionRepository.delete(findById(id));
    }


    @Transactional
    public List<Transaction>  findAllByUserId(Long id) {
        List<Transaction> allByUserId = transactionRepository.findAllByUserId(id);
        return allByUserId;
    }
}
