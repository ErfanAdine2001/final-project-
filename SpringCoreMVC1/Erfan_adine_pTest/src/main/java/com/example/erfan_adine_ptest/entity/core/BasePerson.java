package com.example.erfan_adine_ptest.entity.core;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BasePerson extends BaseEntity{


    private String fName;

    private String lName;

    private String email;

    private String password;

    @Lob
    private byte[] image;

}
