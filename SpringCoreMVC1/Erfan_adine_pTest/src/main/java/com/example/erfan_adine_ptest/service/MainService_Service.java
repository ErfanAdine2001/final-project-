package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.dto.in.work.MainServiceInDto;
import com.example.erfan_adine_ptest.dto.out.work.MainServiceOutDto;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.DutyRepository;
import com.example.erfan_adine_ptest.repository.WorkerRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MainService_Service{
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
    public MainServiceOutDto save(MainServiceInDto entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {

        MainService mainService = new MainService();
        mainService.setName(entity.getName());
        mainService.setWorker(entity.getWorkers());
        mainService.setUpdatedTime(new Date());
        mainService.setCreatedTime(new Date());

        MainServiceOutDto mainServiceOutDto = new MainServiceOutDto();
        mainServiceOutDto.setId(entity.getId());

        return mainServiceOutDto;

    }

    @Transactional
    public MainService findById(Long id) {
        return super.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        super.delete(id);
    }
}
