package com.example.erfan_adine_ptest.entity.core;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass

public class BaseDuty extends BaseEntity{
    @Column(nullable = false)
    @NotNull
    //TODO javax.validation dependency
    private String name;
}
