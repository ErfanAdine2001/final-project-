package com.example.erfan_adine_p1_2.entity.instruction.request;

import com.example.erfan_adine_p1_2.entity.instruction.Order.Order;
import com.example.erfan_adine_p1_2.entity.instruction.message.Base_Message.BaseMessage;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request extends BaseMessage {

     /**
     * my reason:  because in every "Request"
      * we must hve one "Order"
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;




}
