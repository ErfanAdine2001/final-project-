package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.DutyRepository;
import com.example.erfan_adine_ptest.repository.WorkerRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MainService_Service extends Common<MainService, Long> {
    private final DutyRepository dutyRepository;

    private Validation validation;

    private final WorkerRepository workerRepository;

    @PostConstruct
    public void init() {
        setJpaRepository(dutyRepository);
    }


    @Transactional
    public List<MainService> gropById() {
        return dutyRepository.GroupById();
    }


    @Override
    public List<MainService> findAll() {
        return super.findAll();
    }

    @Override
    public void update(Long id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        super.update(id);
    }


    //--------------------------------------------------------
    //TODO f1 -------------------> 1-5 repository
    //TODO e
    @Transactional
    public void removeById(Long id) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException {

        if (Validation.checkBaseCustomerIsValid(workerRepository.findById(id).get())) {
            dutyRepository.removeById(workerRepository.getById(id).getId());
        }
    }

    @Transactional
    public void updateById(Long id) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException {

        if (Validation.checkBaseCustomerIsValid(workerRepository.findById(id).get())) {
            dutyRepository.removeById(workerRepository.getById(id).getId());
        }
    }

    @Transactional
    public MainService findByName(String name) {
        return dutyRepository.findByName(name);
    }

    @Transactional
    @Override
    public MainService save(MainService entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        if (validation.MainServiceIsValid(entity))
            return super.save(entity);
        return null;
    }

    @Transactional
    @Override
    public MainService findById(Long id) {
        return super.findById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
