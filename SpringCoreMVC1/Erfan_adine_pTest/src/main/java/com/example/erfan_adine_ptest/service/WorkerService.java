package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.out.BasPersonOutDto;
import com.example.erfan_adine_ptest.dto.out.ServiceHistoryOutDto;
import com.example.erfan_adine_ptest.dto.out.product.MainOrderOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.security.Role;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.MainService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.DutyRepository;
import com.example.erfan_adine_ptest.repository.WorkerRepository;

import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final DutyRepository dutyRepository;
    private final PasswordEncoder passwordEncoder;


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


    @Transactional
    public BasPersonOutDto save(BasePersonDto request) {
        Worker worker =Worker.builder()
                .fName(request.getFirstName())
                .lName(request.getLastName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .roles(new HashSet<>(List.of(Role.WORKER)))
                .build();
        Worker save = workerRepository.save(worker);
        return new BasPersonOutDto(save.getId());
    }


    //****************************************

    @Transactional
    public void delete(Worker worker) {
        workerRepository.delete(worker);
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


    public List<MainOrder> serviceHistory(Long id) {
        List<MainOrder> mainOrders = workerRepository.serviceHistory(id);
        return mainOrders;
    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Worker worker = workerRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("not found worker with username:" + username));
//
//        return new CustomeWorkerDetail(worker);
//    }
}

