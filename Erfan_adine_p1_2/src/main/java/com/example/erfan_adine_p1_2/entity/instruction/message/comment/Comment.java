package com.example.erfan_adine_p1_2.entity.instruction.message.comment;

import com.example.erfan_adine_p1_2.entity.instruction.Order.Order;
import com.example.erfan_adine_p1_2.entity.instruction.message.Base_Message.BaseMessage;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseMessage {

    @OneToOne(cascade = CascadeType.ALL)
    private Order order;
}
