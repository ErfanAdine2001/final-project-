package com.example.erfan_adine_ptest.entity.product;

import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.user.User;
import com.example.erfan_adine_ptest.entity.work.SubService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name="myComment")
public class Comment extends BaseEntity {
//    @Column(nullable = false)
    private Integer points;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_user_ID_mo")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subService_ID_mo")
    private SubService subService;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID_oo")
    private MainOrder order;
}
