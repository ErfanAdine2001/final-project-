package com.example.erfan_adine_ptest.dto.in;


import com.example.erfan_adine_ptest.dto.core.BaseEntityDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.work.SubService;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInDto extends BaseEntityDto {

    private Long orderId;

    private BigDecimal amount;

    private User payer;

    private SubService recipient;

    private Long workerId;
}
