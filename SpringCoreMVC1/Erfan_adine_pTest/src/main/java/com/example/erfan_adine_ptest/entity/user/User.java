package com.example.erfan_adine_ptest.entity.user;


import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.security.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


//@MappedSuperclass
@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MyUser")
public class User extends BasePerson {


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_ID_om_l")
    private List<MainOrder> orders;

    @Lob
    private byte[] image;

    private BigDecimal UserAccountBalance;


}
