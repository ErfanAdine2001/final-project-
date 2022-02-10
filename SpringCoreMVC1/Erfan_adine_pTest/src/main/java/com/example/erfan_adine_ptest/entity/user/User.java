package com.example.erfan_adine_ptest.entity.user;


import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


//@MappedSuperclass
@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BasePerson {


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_ID_om_l")
    private List<MainOrder> orders;

    @Lob
    private byte[] image;

    private BigDecimal UserAccountBalance;
}
