package com.example.erfan_adine_ptest.dto.in.product;


import com.example.erfan_adine_ptest.dto.core.BaseEntityDto;
import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MainOrderInDto extends BaseEntityDto {

    private String addres;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
