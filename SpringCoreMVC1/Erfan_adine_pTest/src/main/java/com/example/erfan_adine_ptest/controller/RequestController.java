package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.service.RequestService;
import lombok.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class RequestController  {
    private final RequestService requestService;

//    @PostMapping("/showAllOrders")
//    public ResponseEntity<Page<RequestOutDto>> showAllServicesByUserId(@RequestBody RequestInDto request){
//
//
//
//    }


}
