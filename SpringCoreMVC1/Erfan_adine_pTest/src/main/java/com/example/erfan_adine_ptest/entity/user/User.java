package com.example.erfan_adine_ptest.entity.user;


import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


//@MappedSuperclass
@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BasePerson {


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "roles_ID_mm")
    private List<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_ID_om_l")
    private List<MainOrder> orders;

}
