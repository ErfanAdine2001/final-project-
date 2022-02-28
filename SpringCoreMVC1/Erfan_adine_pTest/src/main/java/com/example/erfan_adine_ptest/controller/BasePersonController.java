package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.dto.in.user.AdminInDto;
import com.example.erfan_adine_ptest.dto.out.BasPersonOutDto;
import com.example.erfan_adine_ptest.dto.out.user.AdminOutDto;
import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.exception.*;
import com.example.erfan_adine_ptest.repository.BasePersonRepo;
import com.example.erfan_adine_ptest.service.BasePersonService;
import com.example.erfan_adine_ptest.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/BasePerson")
@RequiredArgsConstructor
public class BasePersonController {
    private final BasePersonService basePersonService;
    private final WorkerService workerService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/create")
    public ResponseEntity<BasPersonOutDto> create(@Valid @RequestBody BasePersonDto request) throws NameOfSubServiceIsNull, NameOfMainServiceIsNull, SuggestionOfPriceIsNullException, NullCommentException, BasePriceOfSubServiceIsNull, NullFieldException, BadEntryException, AddressOfRequestIsNull, NullAddresOfMainOrderException, OrderOfTransactionIsNullExeption, OrderOfRequestIsNullException, NameNotValidException, EmailNotValidException, PasswordNotValidException, RoleIsNullException {


       BasPersonOutDto basePerson =  basePersonService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(basePerson);

    }
}
