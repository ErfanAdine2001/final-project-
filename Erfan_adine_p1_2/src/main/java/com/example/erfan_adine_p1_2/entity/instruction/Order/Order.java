package com.example.erfan_adine_p1_2.entity.instruction.Order;

import com.example.erfan_adine_p1_2.entity.base.BaseEntity;
import com.example.erfan_adine_p1_2.entity.instruction.message.suggestion.SuggestionEmployee;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {
    /**
     * my reason:because I need to know Order Status
     */
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private OrderStatus status=OrderStatus.WAITING_FOR_SELECTION;

    /**
     * my reason:because I need "suggestionEmployee" for "getId()" in Order  :)
     */
    @OneToOne
    private SuggestionEmployee suggestionEmployee;


}
