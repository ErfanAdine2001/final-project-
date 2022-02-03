package com.example.erfan_adine_ptest.dto.in.user;


import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerInDto extends BasePersonDto {

    private MainOrder order;


}
