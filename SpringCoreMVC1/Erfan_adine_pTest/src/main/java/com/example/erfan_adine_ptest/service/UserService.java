package com.example.erfan_adine_ptest.service;

import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.UserRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService extends Common<User, Long> {
    private final UserRepository userRepository;

    private Validation validation;
    private final SuggestionService suggestionService;

    private final MainOrderService mainOrderService;

    @PostConstruct
    public void init() {
        setJpaRepository(userRepository);
    }


    @Transactional
    @Override
    public User save(User entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, SuggestionOfPriceIsNullException {
        if (Validation.checkBaseCustomerIsValid(entity)) {
            try {
                if (validation.checkBaseCustomerIsValid(entity)) {
                    return super.save(entity);
                }
            } catch (NullCommentException | RoleIsNullException | OrderOfTransactionIsNullExeption e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return super.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    // TODO validation email don f--------->1-2  service of user
    @Transactional
    public void changePassword(User user) throws NameNotValidException, EmailNotValidException, PasswordNotValidException, NullFieldException {
//
        if (Validation.checkBaseCustomerIsValid(user)) {
            userRepository.save(user);
        }
    }



//
//    @Transactional
//    public void removeById(Long id, String password) {
//        userRepository.removeById(id, password);
//    }


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
        User user = userRepository.getById(userId);
//        MainOrderInDto mainOrder = mainOrderService.findById(orderId);

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






















