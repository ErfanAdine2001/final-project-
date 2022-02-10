package com.example.erfan_adine_ptest.dto.out.product;

import com.example.erfan_adine_ptest.dto.out.user.UserOutDto;
import com.example.erfan_adine_ptest.dto.out.work.SubServiceOutDto;
import lombok.*;

@Getter
@Setter
public class CommentOutDto {
    private Long id;

    private UserOutDto user;

    private SubServiceOutDto subService;

    private MainOrderOutDto order;
}
