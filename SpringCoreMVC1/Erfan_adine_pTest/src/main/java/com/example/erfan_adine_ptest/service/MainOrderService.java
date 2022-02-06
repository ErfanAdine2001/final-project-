package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.OrderRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public MainOrder save(MainOrder entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.mainServiceIsValid(entity))
            return super.save(entity);
        return null;
    }

    @Transactional
    public List<MainOrder> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public MainOrder findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Transactional
    public void delete(Long id) {
       orderRepository.delete(findById(id));
    }

    @Transactional
    public void update(Long id,String address) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        MainOrder a = findById(id);
        a.setAddres(address);
        orderRepository.save(a);
    }
}
