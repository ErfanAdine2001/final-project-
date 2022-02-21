package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.in.product.CommentInDto;
import com.example.erfan_adine_ptest.dto.in.product.MainOrderInDto;
import com.example.erfan_adine_ptest.dto.out.product.CommentOutDto;
import com.example.erfan_adine_ptest.dto.out.product.MainOrderOutDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.MainOrderService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/mainOrders")
public class MainOrderController {

    private final MainOrderService mainOrderService;


    @PostMapping("/create")
    public ResponseEntity<MainOrderOutDto> create(@Valid @RequestBody MainOrderInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {

        MainOrderOutDto mainOrderOutDto = mainOrderService.save(request);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mainOrderOutDto);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<MainOrder>> findAll() {
        List<MainOrder> list = mainOrderService.findAll();


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(list);

    }

    @GetMapping("/findById/{mainOrderId}")
    public ResponseEntity<CommentOutDto> findById(@PathVariable Long mainOrderId) {
        MainOrder mainOrder = mainOrderService.findById(mainOrderId);

        CommentOutDto commentOutDto = new CommentOutDto();
        commentOutDto.setId(mainOrder.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentOutDto);


    }

    @PutMapping("/update/{mainOrderId}")
    public ResponseEntity<MainOrder> update(@PathVariable Long mainOrderId, @RequestBody CommentInDto commentInDto) {
        MainOrder mainOrder = mainOrderService.findById(mainOrderId);

        commentInDto.setDescription(commentInDto.getDescription());
        commentInDto.setPoints(commentInDto.getPoints());
        commentInDto.setUpdatedTime(new Date());
        commentInDto.setUserId(commentInDto.getUserId());
        commentInDto.setMainOrderId(commentInDto.getMainOrderId());


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mainOrder);


    }

    @DeleteMapping("/delete/{commentId}e")
    public ResponseEntity<String> delete(@PathVariable Long commentId) {
        mainOrderService.delete(commentId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Deleted");


    }


}
