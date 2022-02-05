package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.OrderRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MainOrderService  {
    private final OrderRepository orderRepository;
    private Validation validation;


    @Transactional
    public List<MainOrder> gropById() {
        return orderRepository.GroupById();
    }

    @Transactional
    @Override
    public MainOrder save(MainOrder entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.mainServiceIsValid(entity))
            return super.save(entity);
        return null;
    }

    @Transactional
    @Override
    public List<MainOrder> findAll() {
        return super.findAll();
    }

    @Transactional
    @Override
    public MainOrder findById(Long id) {
        return super.findById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Transactional
    @Override
    public void update(Long id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(id);
    }
}
