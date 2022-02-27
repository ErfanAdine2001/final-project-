package com.example.erfan_adine_ptest.dto.out.user;

import com.example.erfan_adine_ptest.entity.product.OrderStatus;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowAllOrdersByUserIdOutDto {

    private String addres;
    private OrderStatus status;
    private List<Admin> admin;
    private User user;
    private Suggestion suggestion;

}
