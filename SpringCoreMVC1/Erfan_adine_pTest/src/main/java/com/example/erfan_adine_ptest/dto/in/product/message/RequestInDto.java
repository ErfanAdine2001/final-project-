package com.example.erfan_adine_ptest.dto.in.product.message;


import com.example.erfan_adine_ptest.dto.core.BaseMessageDto;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.product.message.BaseMessage;
import com.example.erfan_adine_ptest.entity.product.message.SuggestionStatus;
import com.example.erfan_adine_ptest.entity.user.Worker;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RequestInDto extends BaseMessageDto {

    private String address;

    protected MainOrder order;

    private Worker worker;

    private Double duration;

    @Enumerated(EnumType.STRING)
    private SuggestionStatus suggestionStatus ;
}
