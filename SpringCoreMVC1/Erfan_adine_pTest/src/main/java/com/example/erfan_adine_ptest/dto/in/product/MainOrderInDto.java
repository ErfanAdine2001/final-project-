package com.example.erfan_adine_ptest.dto.in.product;


import com.example.erfan_adine_ptest.dto.core.BaseEntityDto;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MainOrderInDto extends BaseEntityDto {

    private String address;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Long subServiceId;

    private Long suggestionId;

    private Long userId;

    private BigDecimal suggestionPrice;

    private Long subService;

}
