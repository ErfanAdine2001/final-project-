package com.example.erfan_adine_ptest.entity.user;


import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.security.Role;
import com.example.erfan_adine_ptest.entity.work.MainService;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Worker extends BasePerson {


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID_mo")
    private MainOrder order;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mainService_ID_mm_l")
    private Set<MainService> mainService;

    @Lob
    private byte[] image;

    private BigDecimal accountBalance;

    private BigDecimal debtToTheCompany;

    @ElementCollection(targetClass = Role.class , fetch = FetchType.EAGER )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();


    private String username;

    private Boolean isEnable;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return roles.stream().flatMap(r -> r.getAuthority().stream())
                .collect(Collectors.toSet());
    }
}
