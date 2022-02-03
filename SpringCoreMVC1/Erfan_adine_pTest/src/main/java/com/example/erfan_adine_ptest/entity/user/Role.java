package com.example.erfan_adine_ptest.entity.user;



import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import lombok.*;
import javax.persistence.*;



//@MappedSuperclass
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {
//    @Builder.Default
    @Enumerated(EnumType.STRING)
    private  StatusRole statusRole;


}
