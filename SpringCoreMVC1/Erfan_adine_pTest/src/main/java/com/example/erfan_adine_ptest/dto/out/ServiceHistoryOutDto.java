package com.example.erfan_adine_ptest.dto.out;

import com.example.erfan_adine_ptest.entity.Transaction;
import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceHistoryOutDto {

    private String address;
    private Date timeFinishedWork;
    private Date timeStartWork;
    private Long transactionId ;
    private Long suggestionId;
    private OrderStatus status;
    private Long userId;
    private List<Long> adminId;
}
