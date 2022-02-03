package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.Role;
import com.example.erfan_adine_ptest.entity.user.Worker;
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
public class WorkerService extends Common<Worker, Long> {
    private final WorkerRepository workerRepository;
    private final DutyRepository dutyRepository;
    private final MainOrderService mainOrderService;
    private final SuggestionService suggestionService;

    private Validation validation;

    //todo f1 ----------------------> 1-5 service
    @Transactional
    public void addMainService(Long worker_id, Long MainService_id) {
        Worker byId = workerRepository.getById(worker_id);
        MainService byId1 = dutyRepository.getById(MainService_id);
        byId.getMainService().add(byId1);
        workerRepository.save(byId);
    }

    @Transactional
    public void removeByMainService(Long worker_id, Long MainService_id) {
        Worker byId = workerRepository.getById(worker_id);
        MainService byId1 = dutyRepository.getById(MainService_id);
        byId.getMainService().remove(byId1);
        workerRepository.save(byId);
    }

    //-------------------------------------------------------------
    //todo f1 ----------------------> 1-5 service second time

    @Transactional
    public void updateByMainService(Long worker_id, Long MainService_id) {
        Worker byId = workerRepository.getById(worker_id);
        MainService byId1 = dutyRepository.getById(MainService_id);
        byId.getMainService().remove(byId1);
        workerRepository.save(byId);
    }

    @Transactional
    public void updateByIdAndRole(Long worker_id, List<Role> roleList) {
        Worker worker = workerRepository.findById(worker_id).get();
        worker.setRole(roleList);

        workerRepository.save(worker);
    }
    //--
    //-----
    //---------

    //-----------------

    @Transactional
    public Worker save(Worker worker) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException {
        if (validation.checkBaseCustomerIsValid(worker))
            return workerRepository.save(worker);
        return null;
    }

    @Transactional
    public void delete(Worker worker) {
        workerRepository.delete(worker);
    }


    @PostConstruct
    public void init() {
        setJpaRepository(workerRepository);
    }


    //TODO fS 2-1  ----------> Service
    @Transactional
    public void ConfirmationOfOrder(Long idOfMainOrder) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        MainOrder mainOrder = mainOrderService.findById(idOfMainOrder);
        if ((mainOrder.getStatus().equals(OrderStatus.WAITING_FOR_EXPERT))) {
            mainOrder.setStatus(OrderStatus.WAITING_FOR_SUGGESTION);
            mainOrderService.save(mainOrder);
        }


    }

    //TODO fS 2-2   ----------> Service
    @Transactional
    public void sendNewSuggestion(Suggestion suggestion, Long idOfMainOrder) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        Suggestion s = suggestionService.save(suggestion);

        MainOrder mainOrder = mainOrderService.findById(idOfMainOrder);
        if ((mainOrder.getStatus().equals(OrderStatus.WAITING_FOR_SUGGESTION))) {
            mainOrder.setStatus(OrderStatus.ACCEPTED);
            mainOrderService.save(mainOrder);
        }
        s.setOrder(mainOrder);
    }


    // TODO validation email don f--------->1-2  service of worker
    @Transactional
    public void changePassword(Worker worker) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException {
//
        if (Validation.checkBaseCustomerIsValid(worker)) {
            workerRepository.save(worker);
        }
    }

    @Transactional
    public Worker findByName(String name) {
        return workerRepository.findByFirstNameName(name);

    }
}

