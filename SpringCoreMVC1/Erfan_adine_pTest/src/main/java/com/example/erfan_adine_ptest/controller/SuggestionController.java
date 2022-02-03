package com.example.erfan_adine_ptest.controller;


import com.example.erfan_adine_ptest.entity.product.message.BaseMessage;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/suggestions")
public class SuggestionController extends BaseMessage {


}
