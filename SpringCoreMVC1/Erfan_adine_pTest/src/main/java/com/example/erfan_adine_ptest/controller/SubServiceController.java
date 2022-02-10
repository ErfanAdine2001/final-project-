package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.entity.work.SubService;
import com.example.erfan_adine_ptest.service.SubService_Service;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/subServices")
public class SubServiceController{

    private final SubService_Service service;

    @PostMapping("/showAllSubServices")
    public ResponseEntity<List<SubService>> showAllsubServices(){

        List<SubService> subServiceList = service.showSubServices();

        return ResponseEntity.status(HttpStatus.OK)
                .body(subServiceList);

    }



}
