package com.example.erfan_adine_p1_2.entity.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends MainUser{

    @OneToMany
    private Set<Role> Role;
}
