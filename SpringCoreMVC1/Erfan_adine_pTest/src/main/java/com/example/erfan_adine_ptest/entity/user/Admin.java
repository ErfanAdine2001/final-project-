package com.example.erfan_adine_ptest.entity.user;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BasePerson {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_ID_mm")
    private List<Role> role;

    //TODO search for syntax : Auto query generate jpa repository
}
