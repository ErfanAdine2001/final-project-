package com.example.erfan_adine_ptest.dto.in.user;

import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.entity.core.BasePerson;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
public class UserInDto extends BasePersonDto {

    @Lob
    private byte[] image;

}
