package com.example.erfan_adine_ptest.controller.Garbage;

import com.example.erfan_adine_ptest.dto.in.product.MainOrderInDto;
import com.example.erfan_adine_ptest.dto.in.security.RoleInDto;
import com.example.erfan_adine_ptest.dto.out.product.MainOrderOutDto;
import com.example.erfan_adine_ptest.dto.out.security.RoleOutDto;
import com.example.erfan_adine_ptest.entity.security.Role;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.security.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {


    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleOutDto> create(@Valid @RequestBody RoleInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {


        RoleOutDto roleOutDto = roleService.save(request);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleOutDto);

    }



}
