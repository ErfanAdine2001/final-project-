package com.example.erfan_adine_ptest.dto.in.user;


import com.example.erfan_adine_ptest.dto.core.BaseEntityDto;
import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.user.StatusRole;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RoleInDto extends BaseEntityDto {

    private StatusRole statusRole;


}
