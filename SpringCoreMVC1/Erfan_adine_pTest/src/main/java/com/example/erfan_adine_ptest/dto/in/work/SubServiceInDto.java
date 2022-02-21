package com.example.erfan_adine_ptest.dto.in.work;

import com.example.erfan_adine_ptest.dto.core.BaseEntityDto;
import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SubServiceInDto extends BaseEntityDto {


    private String name;

    private BigDecimal basePrice;

    private List<Long> mainServiceId;

}
