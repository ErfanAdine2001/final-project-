package com.example.erfan_adine_ptest.service;


import com.example.erfan_adine_ptest.dto.in.product.message.RequestInDto;
import com.example.erfan_adine_ptest.dto.out.product.message.RequestOutDto;
import com.example.erfan_adine_ptest.entity.product.message.Request;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.RequestRepository;
import com.example.erfan_adine_ptest.service.util.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestOutDto save(RequestInDto entity) throws NullFieldException, BadEntryException, NameNotValidException, EmailNotValidException, PasswordNotValidException, NullCommentException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, BasePriceOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, AddressOfRequestIsNull, RoleIsNullException, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {

        Request request = new Request();
        request.setSubService(entity.getSubService());
        request.setAddress(entity.getAddress());
        request.setOrder(entity.getOrder());
        request.setDetails(entity.getDetails());
        request.setUpdatedTime(new Date());
        request.setCreatedTime(new Date());
        request.setPrice(entity.getPrice());

        Request result = requestRepository.save(request);

        RequestOutDto requestOutDto = new RequestOutDto();
        requestOutDto.setId(result.getId());

        return requestOutDto;
    }

    @Transactional
    public Request findById(Long id) {
        return requestRepository.findById(id).get();
    }

    @Transactional
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        requestRepository.delete(findById(id));
    }

//    @Transactional
//    public void update(Long id) throws NameNotValidException, NullFieldException, BadEntryException, EmailNotValidException, PasswordNotValidException, NullAddresOfMainOrderException, NameOfSubServiceIsNull, NameOfMainServiceIsNull, OrderOfRequestIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, RoleIsNullException, AddressOfRequestIsNull, OrderOfTransactionIsNullExeption, SuggestionOfPriceIsNullException {
//        super.update(id);
//    }
}
