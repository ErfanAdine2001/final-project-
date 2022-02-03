package com.example.erfan_adine_ptest.entity.product;

import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.product.message.Suggestion;
import com.example.erfan_adine_ptest.entity.user.Admin;
import com.example.erfan_adine_ptest.entity.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MainOrder extends BaseEntity {
    @Column
    private String addres;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_ID_mm_l")
    private List<Admin> admin;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID_mo")
    private User user;


    @Enumerated(EnumType.STRING)
    private OrderStatus status;
//    private WorkerInDto worker;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "suggestion_ID_oo")
    private Suggestion suggestion;

}
