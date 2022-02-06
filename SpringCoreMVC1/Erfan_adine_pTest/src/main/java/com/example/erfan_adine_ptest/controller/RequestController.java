package com.example.erfan_adine_ptest.controller;


import com.example.erfan_adine_ptest.dto.in.product.message.RequestInDto;
import com.example.erfan_adine_ptest.dto.out.product.message.RequestOutDto;
import com.example.erfan_adine_ptest.entity.product.message.BaseMessage;
import com.example.erfan_adine_ptest.entity.product.message.SuggestionStatus;
import com.example.erfan_adine_ptest.service.RequestService;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class RequestController  {
    private final RequestService requestService;

    @PostMapping("/showAllOrders")
    public ResponseEntity<Page<RequestOutDto>> showAllServicesByUserId(@RequestBody RequestInDto request){



    }


}
