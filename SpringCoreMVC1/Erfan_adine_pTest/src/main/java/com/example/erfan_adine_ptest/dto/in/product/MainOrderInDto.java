package com.example.erfan_adine_ptest.dto.in.product;


import com.example.erfan_adine_ptest.dto.core.BaseEntityDto;
import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.work.SubService;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MainOrderInDto extends BaseEntityDto {

    private String addres;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private SubService subService;

    private Suggestion suggestionId;

    private User userId;

    private Date timeStartWork;

    private Date timefinishedWork;

     private BigDecimal suggestionPrice;




}
