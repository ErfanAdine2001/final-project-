package com.example.erfan_adine_ptest.dto.core;


import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.product.message.BaseMessageStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseMessageDto extends BaseEntity {



    private BigDecimal price;

    private Date suggestedDateTime;

    private String details;

    private BaseMessageStatus status;
}
