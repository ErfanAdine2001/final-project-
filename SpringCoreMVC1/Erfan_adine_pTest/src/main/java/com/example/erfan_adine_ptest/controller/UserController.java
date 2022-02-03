package com.example.erfan_adine_ptest.controller;

import com.example.erfan_adine_ptest.entity.core.BasePerson;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "roles_ID")
    private List<RoleController> roles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MainOrderController> orders;

}
