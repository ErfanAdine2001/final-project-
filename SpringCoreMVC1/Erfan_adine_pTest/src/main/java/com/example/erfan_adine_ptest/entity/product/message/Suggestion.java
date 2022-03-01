package com.example.erfan_adine_ptest.entity.product.message;


import com.example.erfan_adine_ptest.entity.product.MainOrder;
import com.example.erfan_adine_ptest.entity.user.Worker;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//@EqualsAndHashCode(callSuper = true)
//@Data
//@EqualsAndHashCode(callSuper = true, of = {"owner"})
//@Table(
//        uniqueConstraints = {@UniqueConstraint(columnNames = {"order_id", "owner_id"})}
//)
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name="mySuggestion")
public class Suggestion extends BaseMessage {


    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "order_ID_mo")
    protected MainOrder order;

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "worker_ID_mo")
    private Worker worker;

    private Date duration;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private SuggestionStatus suggestionStatus = SuggestionStatus.PENDING;

    private BigDecimal SuggestionPrice;
}
