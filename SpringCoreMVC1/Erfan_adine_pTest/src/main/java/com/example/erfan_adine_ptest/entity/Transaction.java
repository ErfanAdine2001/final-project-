package com.example.erfan_adine_ptest.entity;

import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.user.Worker;
import com.example.erfan_adine_ptest.entity.work.SubService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//@Table(
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"order_id"})}
//)
public class Transaction extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID_oo")
    private MainOrder order;

    private BigDecimal amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID_mo")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subService_ID_mo")
    private SubService subService;

    @OneToOne
    @JoinColumn(name = "transaction_Id_oo")
    private Worker worker;
}
