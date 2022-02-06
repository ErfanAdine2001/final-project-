package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.dto.in.user.ShowAllOrdersByUserIdInDto;
import com.example.erfan_adine_ptest.dto.in.user.UserInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.out.user.ShowAllOrdersByUserIdOutDto;
import com.example.erfan_adine_ptest.dto.out.user.UserOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.UserRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private Validation validation;
    private final SuggestionService suggestionService;

    private final MainOrderService mainOrderService;

//    @PostConstruct
//    public void init() {
//        setJpaRepository(userRepository);
//    }


    @Transactional
    public UserOutDto save(UserInDto entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, SuggestionOfPriceIsNullException {

        User user = new User();
        user.setEmail(entity.getEmail());
        user.setImage(entity.getImage());
        user.setFName(entity.getFirstName());
        user.setLName(entity.getLastName());
        user.setPassword(entity.getPassword());

        UserOutDto userOutDto = new UserOutDto();
        userOutDto.setId(user.getId());

        return userOutDto;

    }


    public Page<WorkerOrUserSerchOutDto> findAllByFNameAndLName(WorkerOrUserSerchInDto workerOrUserSerchInDto) {
        Pageable pageable = PageRequest.of(workerOrUserSerchInDto.getPageNumber(), workerOrUserSerchInDto.getPageSize());
        return userRepository.findAllByFNameAndLName(workerOrUserSerchInDto.getFName(), workerOrUserSerchInDto.getLName(), pageable);
    }

    public Page<WorkerOrUserSerchOutDto> findAllByFNameAndLNameAndEmailAndPassword(WorkerOrUserSerchInDto workerOrUserSerchInDto) {
        Pageable pageable = PageRequest.of(workerOrUserSerchInDto.getPageNumber(), workerOrUserSerchInDto.getPageSize());
        return userRepository
                .findAllByFNameAndLNameAndEmailAndPassword(workerOrUserSerchInDto.getFName(), workerOrUserSerchInDto.getLName(), workerOrUserSerchInDto.getPassword(), workerOrUserSerchInDto.getEmail(), pageable);
    }


    public Page<ShowAllOrdersByUserIdOutDto> showAllOrdersByUserIdS(ShowAllOrdersByUserIdInDto orders,Long id) {
        Pageable pageable = PageRequest.of(orders.getPageNumber(), orders.getPageSize());
        return userRepository.showAllOrdersByUserIdR(id, pageable);
//        return userRepository.showAllOrdersByUserIdR(orders.getUser().getId(), pageable);
    }


    public User findById(Long id) {
        return userRepository.findById(id).get();
    }




    //                              **********
    //*******                               ****
    //************                      ******
    //*************                 *******
    //                                  ******
    //************                       *****
    //**********                       *****
    //                            *********
    //**************************************
    //**************************************
    //**************************************
    //**************************************
    //*************************
    //****************
    //*************
    //*********
    //******
    //***
    //**
    //*

    @Transactional
    public List<User> findAll() {
        List<User> adminList = new ArrayList<>();
        userRepository.findAll().forEach((element) -> adminList.add(element));

        return adminList;
    }

    @Transactional
    public void delete(Long id) {
        userRepository.delete(findById(id));
    }

    // TODO validation email don f--------->1-2  service of user
    @Transactional
    public void changePassword(User user) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException {

        if (Validation.checkBaseCustomerIsValid(user)) {
            userRepository.save(user);
        }
    }


    //TODO fS 2-3
    @Transactional
    public List<Suggestion> listOfSuggestionByOrderID(Long orderID) {
        List<Suggestion> myList = new ArrayList<Suggestion>();
        List<Suggestion> all = suggestionService.findAll();
        for (Suggestion suggestion : all) {
            if (suggestion.getOrder().getId().equals(orderID)) {
                myList.add(suggestion);
            }
        }
        List<Suggestion> sortMyList = myList.stream().sorted().toList();
        return sortMyList;
//        fixme
    }


    //TODO fS 2-4
    @Transactional
    public void selectWorkersBySuggestionId(Long userId, Long suggestionId, Long orderId) {
        Suggestion suggestion = suggestionService.findById(suggestionId);
        User user = findById(userId);

        List<MainOrder> orders = user.getOrders();
        for (MainOrder order : orders) {
            if (order.getId().equals(orderId)) {
                order.setSuggestion(suggestion);
                order.setStatus(OrderStatus.WAITING_FOR_EXPERT);
            }
        }
        userRepository.save(user);
    }


}






















