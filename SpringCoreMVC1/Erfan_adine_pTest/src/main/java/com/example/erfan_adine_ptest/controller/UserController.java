package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.BankCardInformationInDto;
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
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.product.message.SuggestionStatus;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.*;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final SuggestionService suggestionService;

    private final MainOrderService mainOrderService;

    private final CommentService commentService;

    private final TransactionService transactionService;

    private final WorkerService workerService;


    @PostMapping("/create")
    public ResponseEntity<UserOutDto> create(@Valid @RequestBody UserInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException {

        UserOutDto result = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);

    }


    @PostMapping("/findAllByFNameAndLNameAndEmailAndPassword")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    @PreAuthorize("hasAnyRole('SUB_SERVICE_WRITE')")

    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> findAllByFNameAndLNameAndEmailAndPassword(@Valid @RequestBody WorkerOrUserSerchInDto request) {

        Page<WorkerOrUserSerchOutDto> allByFNameAndLNameAndEmailAndPassword = userService.findAllByFNameAndLNameAndEmailAndPassword(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByFNameAndLNameAndEmailAndPassword);

    }


    @PostMapping("/findAllByFNameAndLName")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    @PreAuthorize("hasAnyRole('SUB_SERVICE_WRITE')")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> findAllByFNameAndLName(@Valid @RequestBody WorkerOrUserSerchInDto request) {

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
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    @PreAuthorize("hasAnyRole('SUB_SERVICE_READ')")

    public ResponseEntity<Page<ShowAllOrdersByUserIdOutDto>> showAllOrders(@Valid @RequestBody ShowAllOrdersByUserIdInDto request, @PathVariable Long id) {

        Page<ShowAllOrdersByUserIdOutDto> showAllOrdersByUserIdOutDtos = userService.showAllOrdersByUserIdS(request, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(showAllOrdersByUserIdOutDtos);
    }


    /**
     * <B>this method add new Main Order</B>
     *
     * @param mainOrderInDto
     */
    @PostMapping("/selectSubServiceAndAddNewMainOrder")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    @PreAuthorize("hasAnyRole('SUB_SERVICE_WRITE','USER_WRITE')")
    public ResponseEntity<MainOrderOutDto> selectSubService(@Valid @RequestBody MainOrderInDto mainOrderInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
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
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    @PreAuthorize("hasAnyRole('SUGGESTION_READ')")
    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> seeTheSuggestionsThatAreACCEPTED(@Valid @RequestBody SuggestionInDto suggestion) {
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
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    @PreAuthorize("hasRole('USER') or hasRole('WORKER')")
    public ResponseEntity<String> selectWorkerWithSuggestionIdAndWaitingForWorkerSelectedU(@Valid @PathVariable Long suggestionId) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        Suggestion s = suggestionService.findById(suggestionId);
        if (s.getSuggestionStatus().equals(SuggestionStatus.ACCEPTED)) {
            MainOrderInDto order = new MainOrderInDto();
            order.setId(s.getOrder().getId());
            order.setSuggestionId(s.getId());
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
    @PreAuthorize("hasRole('USER') or hasRole('WORKER')")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    public ResponseEntity<CommentOutDto> addComment(@Valid @RequestBody CommentInDto commentInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        CommentOutDto commentOutDto = commentService.save(commentInDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentOutDto);
    }

    //TODO  مشاهده تاریخچه سفارشات و اعتبار
    @PostMapping("/findAllOrder")
    @PreAuthorize("hasRole('USER') or hasRole('WORKER')")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    public ResponseEntity<List<MainOrder>> findAllOrder(@Valid @RequestBody MainOrderInDto mainOrderInDto) {
        List<MainOrder> allOrderByStatusOfStatus = mainOrderService.findAllOrderByStatusOfStatus(mainOrderInDto.getStatus());

        return ResponseEntity.status(HttpStatus.OK)
                .body(allOrderByStatusOfStatus);

    }

    //TODO مشاهده تاریخچه سفارشات و اعتبار
    @GetMapping("/loadAmount/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('WORKER')")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    public ResponseEntity<List<Transaction>> loadAmount(@Valid @PathVariable Long userId) {
        List<Transaction> transactionList = transactionService.findAllByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionList);

    }

    //TODO    3-2 ----- پس از اعلام پایان  customer     @@@@@@@@@@@@@@@@@@@@@@@@@@@@  how can set time for come in page    and    how can i set captcha
    @PostMapping("/creditPayMoney")
    @PreAuthorize("hasRole('USER') or hasRole('WORKER')")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    public ResponseEntity<String> CreditPayMoney(@Valid @RequestBody TransactionInDto transactionInDto, @RequestBody BankCardInformationInDto bankCardInformationInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {


        if (mainOrderService.findById(transactionInDto.getOrderId()).getStatus().equals(OrderStatus.DONE) && checkBalanceAccount(transactionInDto)) {


            Transaction transaction = new Transaction();
            transaction.setOrder(mainOrderService.findById(transactionInDto.getOrderId()));
            transaction.setAmount(transactionInDto.getAmount());
            transaction.setWorker(workerService.findById(transactionInDto.getWorkerId()));
            transactionService.save(transaction);


            User user = userService.findById(transactionInDto.getId());
            user.setUserAccountBalance(user.getUserAccountBalance().subtract(transactionInDto.getAmount()));
            userService.save(user);

            MainOrder mainOrder = mainOrderService.findById(transactionInDto.getOrderId());
            mainOrder.setTransaction(transactionService.findById(transactionInDto.getId()));
            mainOrder.setStatus(OrderStatus.PAID);
            mainOrderService.save(mainOrder);

            Worker worker = workerService.findById(transactionInDto.getWorkerId());
            BigDecimal amount = transaction.getAmount();
            BigDecimal accountBalance = amount.subtract((amount.multiply(new BigDecimal(30).divide(new BigDecimal(100)))));
            worker.setAccountBalance(accountBalance);
            worker.setDebtToTheCompany(amount.subtract(accountBalance));


            workerService.save(worker);


        } else if (mainOrderService.findById(transactionInDto.getOrderId()).getStatus().equals(OrderStatus.DONE) && checkBalanceBank(transactionInDto, bankCardInformationInDto)) {

            Transaction transaction = new Transaction();
            transaction.setOrder(mainOrderService.findById(transactionInDto.getOrderId()));
            transaction.setAmount(transactionInDto.getAmount());
            transaction.setWorker(workerService.findById(transactionInDto.getWorkerId()));
            transactionService.save(transaction);

            //"subtract transaction amount"  from  " bank card  balance"
            bankCardInformationInDto.setBalance(bankCardInformationInDto.getBalance().subtract(transactionInDto.getAmount()));

            MainOrder mainOrder = mainOrderService.findById(transactionInDto.getOrderId());
            mainOrder.setTransaction(transactionService.findById(transactionInDto.getId()));
            mainOrder.setStatus(OrderStatus.PAID);
            mainOrderService.save(mainOrder);

            Worker worker = workerService.findById(transactionInDto.getWorkerId());
            BigDecimal amount = transaction.getAmount();
            BigDecimal accountBalance = amount.subtract((amount.multiply(new BigDecimal(30).divide(new BigDecimal(100)))));
            worker.setAccountBalance(accountBalance);
            worker.setDebtToTheCompany(amount.subtract(accountBalance));


            workerService.save(worker);


        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(null);

    }


    //TODO  3-2 ----- پرداخت      @@@@@@@@@@@@@
    public Boolean checkBalanceBank(TransactionInDto transactionInDto, BankCardInformationInDto bankCardInformationInDto) {

        BigDecimal balance = bankCardInformationInDto.getBalance();

        if (transactionInDto.getAmount().compareTo(balance) == -1) {
            return true;
        }
        return false;

    }

    public Boolean checkBalanceAccount(TransactionInDto transactionInDto) {

        User user = userService.findById(transactionInDto.getId());
        int b = user.getUserAccountBalance().compareTo(transactionInDto.getAmount());

        return b > 0;

    }


    //TODO    3-2 ----- پس از اعلام پایان  customer     @@@@@@@@@@@@@@@@@@@@@@@@@@@@-
    @PostMapping("/cashPayMoney")
    @PreAuthorize("hasRole('USER') or hasRole('WORKER')")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    public ResponseEntity<String> cashPayMoney(@RequestBody TransactionInDto transactionInDto) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        if (mainOrderService.findById(transactionInDto.getOrderId()).getStatus() == OrderStatus.DONE) {

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


    @GetMapping("/ServiceHistory/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('WORKER')")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('admin') or hasRole('user') or hasRole('USER')")
    public ResponseEntity<List<MainOrder>> serviceHistory(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.ServiceHistory(userId));

    }

    @GetMapping("/login")
    public String login() {
        return "";
    }

}
