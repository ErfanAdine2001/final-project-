package com.example.erfan_adine_ptest.controller;


import com.example.erfan_adine_ptest.dto.in.product.MainOrderInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.out.product.message.SuggestionOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.message.BaseMessageStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.MainOrderService;
import com.example.erfan_adine_ptest.service.SuggestionService;
import com.example.erfan_adine_ptest.service.WorkerService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

    private final SuggestionService suggestionService;
    private final WorkerService workerService;
    private final MainOrderService mainOrderService;

    @PostMapping
    public ResponseEntity<WorkerOutDto> create(@Valid @RequestBody WorkerInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        WorkerOutDto workerOutDto = workerService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(workerOutDto);

    }


    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> findAllByFNameAndLNameAndEmailAndPassword(WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        Page<WorkerOrUserSerchOutDto> allByFNameAndLNameAndEmailAndPassword = workerService.findAllByFNameAndLNameAndEmailAndPassword(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(allByFNameAndLNameAndEmailAndPassword);

    }


    public ResponseEntity<Page<WorkerOrUserSerchOutDto>> findAllByFNameAndLName(WorkerOrUserSerchInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        Page<WorkerOrUserSerchOutDto> findAllByFNameAndLName = workerService.findAllByFNameAndLName(request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(findAllByFNameAndLName);

    }


    /**
     * <b>++++++++++++++++++++++++++++++++++</b>
     * <br>
     * <b>this method show all pagination Orders  of user by Id</b>
     */
    @PostMapping
    public ResponseEntity<List<MainOrder>> findSuggestionForMainOrder() {
        List<MainOrder> allOrderByStatusWateFOrSuggestions = workerService.findAllOrderByStatusWateFOrSuggestions();

        return ResponseEntity.status(HttpStatus.OK)
                .body(allOrderByStatusWateFOrSuggestions);
    }


    /**
     * <b>send suggestion for Main order by "OrderId"</b>
     *
     * @param orderId
     */
    @PostMapping("/sendSuggestion/{workerId}/{orderId}")
    public ResponseEntity<SuggestionOutDto> sendSuggestionForMainOrder(@PathVariable Long orderId, @RequestBody MainOrderInDto mainOrderInDto, @PathVariable Long workerId) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {
        MainOrder m = mainOrderService.findById(orderId);
        Worker w = workerService.findById(workerId);
        Suggestion suggestion = new Suggestion();
        suggestion.setWorker(w);
        suggestion.setOrder(m);
        suggestion.setStatus(BaseMessageStatus.WAITING);
        suggestion.setPrice(mainOrderInDto.getSuggestionPrice());

        m.setSuggestion(suggestion);

        suggestionService.save(suggestion);

        SuggestionOutDto suggestionOutDto = new SuggestionOutDto();
        suggestionOutDto.setId(suggestion.getId());

        return ResponseEntity.status(HttpStatus.OK)
                .body(suggestionOutDto);

//       mainOrderInDto.getTimeStartWork() -(mainOrderInDto.getTimefinishedWork());
//        suggestion.setDuration();
    }


}
