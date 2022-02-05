package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.ExperteRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExperteService  {
    private final ExperteRepository experteRepository;
    private Validation validation;

    @PostConstruct
    public void init() {
        setJpaRepository(experteRepository);
    }


    @Transactional
    @Override
    public SubService save(SubService entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.ExperteOrSubServiceIsValid(entity)) {
            return super.save(entity);
        }

        return null;
    }

    @Transactional
    public SubService findById(Long id) {
        return super.findById(id);
    }

    @Transactional
    public List<SubService> findAll() {
        return super.findAll();
    }


    @Transactional
    public void update(Long id) throws MistakeInService, NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(id);
    }

    @Transactional
    public void delete(Long aLong) {
        super.delete(aLong);
    }
}
