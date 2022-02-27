package com.example.erfan_adine_ptest.entity.user;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Admin extends BasePerson {


    //TODO search for syntax : Auto query generate jpa repository
}
