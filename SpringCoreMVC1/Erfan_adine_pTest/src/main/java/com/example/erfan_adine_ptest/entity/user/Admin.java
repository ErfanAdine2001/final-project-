package com.example.erfan_adine_ptest.entity.user;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import com.example.erfan_adine_ptest.entity.security.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Admin extends BasePerson {


    //TODO search for syntax : Auto query generate jpa repository
}
