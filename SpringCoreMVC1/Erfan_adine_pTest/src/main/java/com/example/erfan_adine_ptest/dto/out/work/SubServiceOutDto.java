package com.example.erfan_adine_ptest.dto.out.work;

import com.example.erfan_adine_ptest.entity.product.message.Request;
import com.example.erfan_adine_ptest.entity.work.MainService;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SubServiceOutDto {
    private Long id;
    private BigDecimal basePrice;
    private String name;
    private Request request;
}
