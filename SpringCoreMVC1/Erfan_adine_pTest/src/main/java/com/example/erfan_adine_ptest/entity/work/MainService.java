package com.example.erfan_adine_ptest.entity.work;


import com.example.erfan_adine_ptest.entity.core.BaseEntity;
import com.example.erfan_adine_ptest.entity.user.Worker;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MainService extends BaseEntity {


    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @Builder.Default
    @JoinColumn(name = "worker_ID_mm")
    private Set<Worker> worker=new HashSet<>();

    private  String description;

}
