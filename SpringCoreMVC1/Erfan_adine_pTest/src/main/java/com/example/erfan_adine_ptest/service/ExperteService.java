package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.ExperteRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ExperteService  {
    private final ExperteRepository experteRepository;

    private Validation validation;




    @Transactional
    public SubService save(SubService entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.ExperteOrSubServiceIsValid(entity)) {
            return super.save(entity);
        }

        return null;
    }

    @Transactional
    public SubService findById(Long id) {
      experteRepository.findById(id);

    }

    @Transactional
    public List<SubService> findAll() {
        List<SubService> subServiceList = new ArrayList<>();
        experteRepository.findAll().forEach((element) -> subServiceList.add(element));

        return subServiceList;
    }


    @Transactional
    public void updateBasePrice(Long id , BigDecimal price)throws MistakeInService, NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        SubService s = findById(id);
        s.setBasePrice(price);
        experteRepository.save(s);
    }

    @Transactional
    public void delete(Long id) {
        experteRepository.delete(findById(id));
    }
}
