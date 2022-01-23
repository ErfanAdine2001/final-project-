package com.example.erfan_adine_p1_2.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.sql.Blob;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseUser extends BaseEntity{

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Lob
    private Blob image;
}
