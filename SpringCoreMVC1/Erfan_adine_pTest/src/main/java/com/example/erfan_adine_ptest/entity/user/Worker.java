package com.example.erfan_adine_ptest.entity.user;


import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.work.MainService;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Worker extends BasePerson {


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_ID_mm_l")
    private List<Role> role;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID_mo")
    private MainOrder order;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mainService_ID_mm_l")
    private Set<MainService> mainService;

}
