package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.dto.in.product.MainOrderInDto;
import com.example.erfan_adine_ptest.dto.out.product.MainOrderOutDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.OrderRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MainOrderService {
    private final OrderRepository orderRepository;
    private final SubService_Service subServiceService;
    private final  SuggestionService suggestionService;
    private final UserService userService;



    @Transactional
    public List<MainOrder> gropById() {
        return orderRepository.GroupById();
    }

    @Transactional
    public MainOrderOutDto save(MainOrderInDto entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        MainOrder order = new MainOrder();
        order.setStatus(OrderStatus.WAITING_FOR_SUGGESTION);
        order.setSubService(subServiceService.findById(entity.getSubService()));
        order.setSuggestion(suggestionService.findById(entity.getSuggestionId()));
        order.setUpdatedTime(new Date());
        order.setCreatedTime(new Date());
        order.setUser(userService.findById(entity.getUserId()));

        MainOrderOutDto mainOrderOutDto = new MainOrderOutDto();
        mainOrderOutDto.setId(order.getId());

        return mainOrderOutDto;

    }





    @Transactional
    public MainOrderOutDto save(MainOrder entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        MainOrder order = new MainOrder();
        order.setStatus(OrderStatus.WAITING_FOR_SUGGESTION);
        order.setSubService(entity.getSubService());
        order.setSuggestion(entity.getSuggestion());
        order.setAddres(entity.getAddres());
        order.setUpdatedTime(new Date());
        order.setCreatedTime(new Date());
        order.setUser(entity.getUser());
        order.setSuggestion(entity.getSuggestion());

        orderRepository.save(order);

        MainOrderOutDto mainOrderOutDto = new MainOrderOutDto();
        mainOrderOutDto.setId(order.getId());

        return mainOrderOutDto;

    }


    //************

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
    public void update(Long id, String address) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
        MainOrder a = findById(id);
        a.setAddres(address);
        orderRepository.save(a);
    }

    @Transactional
    public List<MainOrder> findAllOrderByStatusWateForSuggestion(OrderStatus status) {
        List<MainOrder> allByStatus = orderRepository.findAllByStatus(status);
        List<MainOrder> finalOrder = new ArrayList<>();
        for (MainOrder order : allByStatus) {

            if (order.getStatus().equals(OrderStatus.WAITING_FOR_SUGGESTION)){

                finalOrder.add(order);

            }
        }
        return finalOrder;
    }



    //TODO   مشاهده تاریخچه سفارشات و اعتبار  service
    @Transactional
    public List<MainOrder> findAllOrderByStatusOfStatus(OrderStatus status) {
        List<MainOrder> allByStatus = orderRepository.findAllByStatus(status);
        List<MainOrder> finalOrder = new ArrayList<>();
        for (MainOrder order : allByStatus) {

            if (order.getStatus().equals(status)){

                finalOrder.add(order);

            }
        }
        return finalOrder;
    }



}
