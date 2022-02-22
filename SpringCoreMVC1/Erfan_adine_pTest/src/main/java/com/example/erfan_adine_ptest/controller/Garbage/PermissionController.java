package com.example.erfan_adine_ptest.controller.Garbage;

import com.example.erfan_adine_ptest.dto.in.security.PermissionInDto;
import com.example.erfan_adine_ptest.dto.out.security.PermissionOutDto;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.service.security.PermissionService;
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
@RequestMapping("/permission")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("/create")
    public ResponseEntity<PermissionOutDto> create(@Valid @RequestBody PermissionInDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {


        PermissionOutDto permissionOutDto = permissionService.save(request);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(permissionOutDto);

    }



}
