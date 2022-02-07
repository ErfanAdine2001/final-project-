package com.example.erfan_adine_ptest.controller;


import com.example.erfan_adine_ptest.dto.in.product.MainOrderInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerInDto;
import com.example.erfan_adine_ptest.dto.in.user.WorkerOrUserSerchInDto;
import com.example.erfan_adine_ptest.dto.out.product.PointsCommetnsOutDto;
import com.example.erfan_adine_ptest.dto.out.product.message.SuggestionOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOrUserSerchOutDto;
import com.example.erfan_adine_ptest.dto.out.user.WorkerOutDto;
import com.example.erfan_adine_ptest.entity.product.Comment;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.BaseMessageStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.product.message.SuggestionStatus;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.CommentService;
import com.example.erfan_adine_ptest.service.MainOrderService;
import com.example.erfan_adine_ptest.service.SuggestionService;
import com.example.erfan_adine_ptest.service.WorkerService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerController {

    private final SuggestionService suggestionService;
    private final WorkerService workerService;
    private final MainOrderService mainOrderService;
    private final CommentService commentService;
    private  PointsCommetnsOutDto pointsCommetnsOutDto;

    @PostMapping("/create")
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
    @PostMapping("findSuggestionForMainOrder")
    public ResponseEntity<List<MainOrder>> findSuggestionForMainOrder(@RequestBody MainOrderInDto mainOrderInDto) {
        List<MainOrder> allOrderByStatusWateFOrSuggestions = workerService.findAllOrderByStatusWateFOrSuggestions(mainOrderInDto.getStatus());

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
        suggestion.setSuggestionStatus(SuggestionStatus.ACCEPTED);
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

    //TODO ثبت نظرات
    @PostMapping("/loadCommentsByOrderId/{orderId}")
    public ResponseEntity<PointsCommetnsOutDto> loadCommentsByOrderId( @PathVariable Long orderId){

//        MainOrder mainOrder = mainOrderService.findById(orderId);
        List<Comment> commentList = commentService.findAll();
        List<Comment> finalList = new ArrayList<>();
        List<Integer> finalPointsList = new ArrayList<>();

        for(Comment comment : commentList){
            if (comment.getOrder().getId().equals(orderId)){
                finalList.add(comment);
            }
        }

        for(Comment comment : finalList){
            finalPointsList.add(comment.getPoints());
        }
        pointsCommetnsOutDto.setPoint(finalPointsList);

        return ResponseEntity.status(HttpStatus.OK)
                        .body(pointsCommetnsOutDto);

    }

    //TODO  مشاهده تاریخچه سفارشات و اعتبار

    public ResponseEntity<List<MainOrder>> findAllOrder(MainOrderInDto mainOrderInDto){
        List<MainOrder> allOrderByStatusOfStatus = mainOrderService.findAllOrderByStatusOfStatus(mainOrderInDto.getStatus());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(allOrderByStatusOfStatus);

    }



}
