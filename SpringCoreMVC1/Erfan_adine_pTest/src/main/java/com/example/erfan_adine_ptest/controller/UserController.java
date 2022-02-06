package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.product.MainOrderInDto;
import com.example.erfan_adine_ptest.dto.in.user.ShowAllOrdersByUserIdInDto;
import com.example.erfan_adine_ptest.dto.in.user.UserInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.out.product.MainOrderOutDto;
import com.example.erfan_adine_ptest.dto.out.user.ShowAllOrdersByUserIdOutDto;
import com.example.erfan_adine_ptest.dto.out.user.UserOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.MainOrderService;
import com.example.erfan_adine_ptest.service.RequestService;
import com.example.erfan_adine_ptest.service.SubService_Service;
import com.example.erfan_adine_ptest.service.UserService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final SubServiceController serviceController;

    private final SubService_Service service_service;

    private final RequestService requestService;

    private final MainOrderService mainOrderService;


//    private final

    @PostMapping("/create")
    public ResponseEntity<UserOutDto> create(@Valid @RequestBody UserInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        UserOutDto result = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);

    }


    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> findAllByFNameAndLNameAndEmailAndPassword(WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        Page<WorkerOrUserSerchOutDto> allByFNameAndLNameAndEmailAndPassword = userService.findAllByFNameAndLNameAndEmailAndPassword(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByFNameAndLNameAndEmailAndPassword);

    }


    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> findAllByFNameAndLName(WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        Page<WorkerOrUserSerchOutDto> allByFNameAndLNameAndEmailAndPassword = userService.findAllByFNameAndLName(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByFNameAndLNameAndEmailAndPassword);

    }

    /**
     * <b>++++++++++++++++++++++++++++++++++</b>
     * <br>
     * <b>this method show all pagination Orders  of user by Id</b>
     *
     * @param request
     * @return
     */
    @PostMapping("/showAllOrders/{id}")
    public ResponseEntity<Page<ShowAllOrdersByUserIdOutDto>> showAllOrders(@RequestBody ShowAllOrdersByUserIdInDto request, @PathVariable Long id) {

        Page<ShowAllOrdersByUserIdOutDto> showAllOrdersByUserIdOutDtos = userService.showAllOrdersByUserIdS(request, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(showAllOrdersByUserIdOutDtos);
    }


    @PostMapping("/showAllSubService")
    public ResponseEntity<List<SubService>> showAllSubServices() {

        ResponseEntity<List<SubService>> listResponseEntity = serviceController.showAllsubServices();
        return listResponseEntity.status(HttpStatus.OK)
                .body(listResponseEntity.getBody());

    }

    /**
     * <B>this method add new Main Order</B>
     *
     * @param mainOrderInDto
     * @return
     * @throws NameOfSubServiceIsNull
     * @throws NameOfMainServiceIsNull
     * @throws SuggestionOfPriceIsNullException
     * @throws NullCommentException
     * @throws BasePriceOfSubServiceIsNull
     * @throws NullFieldException
     * @throws BadEntryException
     * @throws AddressOfRequestIsNull
     * @throws NullAddresOfMainOrderException
     * @throws OrderOfTransactionIsNullExeption
     * @throws OrderOfRequestIsNullException
     * @throws NameNotValidException
     * @throws EmailNotValidException
     * @throws PasswordNotValidException
     * @throws RoleIsNullException
     */
    @PostMapping("/selectSubServiceAndAddNewMainOrder")
    public ResponseEntity<MainOrderOutDto> selectSubService(@RequestBody MainOrderInDto mainOrderInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        MainOrderOutDto mainOrderOutDto = mainOrderService.save(mainOrderInDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mainOrderOutDto);
    }


}
