package com.example.erfan_adine_ptest.entity.product.message;



import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.user.User;
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
public class Request extends BaseMessage {


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ID_oo")
    protected MainOrder order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_ID_mo")
    private User user;

    private String address;
}
