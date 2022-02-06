package com.example.erfan_adine_ptest.dto.out.product.message;


import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.message.SuggestionStatus;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.SubService;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class RequestOutDto {

    private Long id;

    private String address;

    protected MainOrder order;

    private Worker worker;

    private Double duration;

    @Enumerated(EnumType.STRING)
    private SuggestionStatus suggestionStatus ;

    private SubService subService;

    private User user;
}
