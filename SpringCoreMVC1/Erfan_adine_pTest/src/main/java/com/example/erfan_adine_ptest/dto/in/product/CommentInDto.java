package com.example.erfan_adine_ptest.dto.in.product;

import com.example.erfan_adine_ptest.dto.core.BaseEntityDto;
import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.work.SubService;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CommentInDto extends BaseEntityDto {

    private Integer points;
    private String description;
    private User sender;
    private SubService recipient;
    private MainOrder order;
    private SubService subService;
}
