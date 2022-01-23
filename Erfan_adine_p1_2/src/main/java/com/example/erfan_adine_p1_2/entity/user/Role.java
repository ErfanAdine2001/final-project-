package com.example.erfan_adine_p1_2.entity.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Builder.Default
    @Enumerated(EnumType.STRING)
    private RoleStatus roleStatus;


}
