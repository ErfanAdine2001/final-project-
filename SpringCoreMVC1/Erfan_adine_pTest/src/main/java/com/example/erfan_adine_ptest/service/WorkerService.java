package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.out.ServiceHistoryOutDto;
import com.example.erfan_adine_ptest.dto.out.product.MainOrderOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.DutyRepository;
import com.example.erfan_adine_ptest.repository.WorkerRepository;
import com.example.erfan_adine_ptest.security.detail.CustomeUserDetail;
import com.example.erfan_adine_ptest.security.detail.CustomeWorkerDetail;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService implements UserDetailsService {
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

    //--
    //-----
    //---------

    //-----------------

    @Transactional
    public WorkerOutDto save(WorkerInDto request) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException {

        Worker worker = new Worker();
        worker.setFName(request.getFirstName());
        worker.setLName(request.getLastName());
        worker.setImage(request.getImage());
        worker.setCreatedTime(new Date());
        worker.setUpdatedTime(new Date());
        worker.setEmail(request.getEmail());
        worker.setMainService(request.getMainServiceList());
         workerRepository.save(worker);

        WorkerOutDto workerOutDto = new WorkerOutDto();
        workerOutDto.setId(worker.getId());

        return workerOutDto;


    }


    @Transactional
    public WorkerOutDto save(Worker request) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException {

        Worker save = workerRepository.save(request);

        WorkerOutDto workerOutDto = new WorkerOutDto();
        workerOutDto.setId(save.getId());

        return workerOutDto;

    }





    //****************************************

    @Transactional
    public void delete(Worker worker) {
        workerRepository.delete(worker);
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

    @Transactional
    public Worker findById(Long id) {
        return workerRepository.findById(id).get();

    }

    //**************************************
//    pagination  all  users

    public Page<WorkerOrUserSerchOutDto> findAllByFNameAndLName(WorkerOrUserSerchInDto workerOrUserSerchInDto) {
        Pageable pageable = PageRequest.of(workerOrUserSerchInDto.getPageNumber(), workerOrUserSerchInDto.getPageSize());
        return workerRepository.findAllByFNameAndLName(workerOrUserSerchInDto.getFName(), workerOrUserSerchInDto.getLName(), pageable);
    }

    public Page<WorkerOrUserSerchOutDto> findAllByFNameAndLNameAndEmailAndPassword(WorkerOrUserSerchInDto workerOrUserSerchInDto) {
        Pageable pageable = PageRequest.of(workerOrUserSerchInDto.getPageNumber(), workerOrUserSerchInDto.getPageSize());
        return workerRepository
                .findAllByFNameAndLNameAndEmailAndPassword(workerOrUserSerchInDto.getFName(), workerOrUserSerchInDto.getLName(), workerOrUserSerchInDto.getPassword(), workerOrUserSerchInDto.getEmail(), pageable);
    }

    //**************************************

    public List<MainOrder> findAllOrderByStatusWateFOrSuggestions(OrderStatus status) {
        List<MainOrder> allOrderByStatusWateForSuggestion = mainOrderService.findAllOrderByStatusWateForSuggestion(status);
        return allOrderByStatusWateForSuggestion;
    }



    public List<MainOrder> serviceHistory(Long id){
        List<MainOrder> mainOrders = workerRepository.serviceHistory(id);
        return mainOrders;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Worker worker = workerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("not found worker with username:" + username));

        return new CustomeWorkerDetail(worker);
    }
}

