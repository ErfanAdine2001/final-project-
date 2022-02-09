package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.TransactionInDto;
import com.example.erfan_adine_ptest.dto.in.product.CommentInDto;
import com.example.erfan_adine_ptest.dto.in.product.MainOrderInDto;
import com.example.erfan_adine_ptest.dto.in.product.message.SuggestionInDto;
import com.example.erfan_adine_ptest.dto.in.user.ShowAllOrdersByUserIdInDto;
import com.example.erfan_adine_ptest.dto.in.user.UserInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.out.product.CommentOutDto;
import com.example.erfan_adine_ptest.dto.out.product.MainOrderOutDto;
import com.example.erfan_adine_ptest.dto.out.user.ShowAllOrdersByUserIdOutDto;
import com.example.erfan_adine_ptest.dto.out.user.UserOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.entity.Transaction;
import com.example.erfan_adine_ptest.entity.product.Comment;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.product.message.SuggestionStatus;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.*;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final SubServiceController serviceController;

    private final SubService_Service service_service;

    private final RequestService requestService;

    private final SuggestionService suggestionService;

    private final MainOrderService mainOrderService;

    private final CommentService commentService;

    private final TransactionService transactionService;

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
     */
    @PostMapping("/selectSubServiceAndAddNewMainOrder")
    public ResponseEntity<MainOrderOutDto> selectSubService(@RequestBody MainOrderInDto mainOrderInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        MainOrderOutDto mainOrderOutDto = mainOrderService.save(mainOrderInDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mainOrderOutDto);
    }

    /**
     * <b>can find all "suggestion" if "Suggestion Status" equal with   " SuggestionStatus.ACCEPTED" </b>
     *
     * @param suggestion
     * @return
     */
    @PostMapping("/seeTheSuggestionsThatAreACCEPTED")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> seeTheSuggestionsThatAreACCEPTED(@RequestBody SuggestionInDto suggestion) {
        Pageable pageable = PageRequest.of(suggestion.getPageNumber(), suggestion.getPageSize());
        Page<WorkerOrUserSerchOutDto> allByStatusOrder = suggestionService.findAllBystatusOrder(pageable, SuggestionStatus.ACCEPTED);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByStatusOrder);

    }

    /**
     * <b> here customer select his/her suggestion and then waiting for coming worker to place location </b>
     *
     * @param suggestionId
     */
    @PostMapping("/selectWorkerWithSuggestionIdAndWaitingForWorkerSelected/{suggestionId}")
    public ResponseEntity<String> selectWorkerWithSuggestionIdAndWaitingForWorkerSelectedU(@Valid @PathVariable Long suggestionId) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        Suggestion s = suggestionService.findById(suggestionId);
        if (s.getSuggestionStatus().equals(SuggestionStatus.ACCEPTED)) {
            MainOrderInDto order = new MainOrderInDto();
            order.setId(s.getOrder().getId());
            order.setSuggestion(s);
            order.setStatus(OrderStatus.WAITING_FOR_COMING_WORKER);

            mainOrderService.save(order);


            return ResponseEntity.status(HttpStatus.OK)
                    .body("Waiting For Coming Worker ");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(null);
    }


    // user can save his/her comment for order
    //TODO  ثبت نظرات
    @PostMapping("/addComment")
    public ResponseEntity<CommentOutDto> addComment(@RequestBody CommentInDto commentInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        Comment comment = commentService.save(commentInDto);

        CommentOutDto commentOutDto = new CommentOutDto();
        commentOutDto.setId(comment.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentOutDto);
    }

    //TODO  مشاهده تاریخچه سفارشات و اعتبار
    @PostMapping("/findAllOrder")
    public ResponseEntity<List<MainOrder>> findAllOrder(@RequestBody MainOrderInDto mainOrderInDto) {
        List<MainOrder> allOrderByStatusOfStatus = mainOrderService.findAllOrderByStatusOfStatus(mainOrderInDto.getStatus());

        return ResponseEntity.status(HttpStatus.OK)
                .body(allOrderByStatusOfStatus);

    }

    //TODO مشاهده تاریخچه سفارشات و اعتبار
    @PostMapping("/loadAmount/{userId}")
    public ResponseEntity<List<Transaction>> loadAmount(@PathVariable Long userId) {
        List<Transaction> transactionList = transactionService.findAllByUserId(userId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transactionList);

    }

    //TODO    3-2 ----- پس از اعلام پایان  customer
    public ResponseEntity<String> CreditPayMoney( @RequestBody TransactionInDto transactionInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        if (mainOrderService.findById(transactionInDto.getOrderId()).getStatus().equals(OrderStatus.DONE)){

            Transaction transaction = new Transaction();
            transaction.setOrder(mainOrderService.findById(transactionInDto.getOrderId()));
            transaction.setAmount(transactionInDto.getAmount());
            transactionService.save(transaction);

            MainOrder mainOrder = mainOrderService.findById(transactionInDto.getOrderId());
            mainOrder.setTransaction(transactionService.findById(transactionInDto.getId()));

            mainOrderService.save(mainOrder);


        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(null);

    }


    public ResponseEntity<String> cashPayMoney( @RequestBody TransactionInDto transactionInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        if (mainOrderService.findById(transactionInDto.getOrderId()).getStatus()==OrderStatus.DONE){

            Transaction transaction = new Transaction();
            transaction.setOrder(mainOrderService.findById(transactionInDto.getOrderId()));
            transaction.setAmount(transactionInDto.getAmount());
            transactionService.save(transaction);

            MainOrder mainOrder = mainOrderService.findById(transactionInDto.getOrderId());
            mainOrder.setTransaction(transactionService.findById(transactionInDto.getId()));

            mainOrderService.save(mainOrder);


        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(null);

    }





//    @PostMapping("")
//    public void AcceptTheSelect(@RequestBody MainOrderInDto mainOrderInDto) {
//        Suggestion suggestion = mainOrderInDto.getSuggestion();
//        mainOrderService.save()
//
//    }

}
