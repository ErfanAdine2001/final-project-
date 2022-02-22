package com.example.erfan_adine_ptest.dto.in.user;

import com.example.erfan_adine_ptest.dto.core.BasePersonDto;
import com.example.erfan_adine_ptest.entity.core.BasePerson;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
public class UserInDto {


    private String firstName;

    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{3,}$")
    private String password;
//

    @Builder.Default
    private Boolean isEnabled = true;
//
//    private String firstName;
//
//    private String lastName;
//
//    @Email
//    private String email;
//
//    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{3,}$")
//    private String password;
//
//    private String role;

//    @Lob
//    private byte[] image;


//    public UserInDto(String firstName, String lastName, String email,String password) {
//
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//    }
}
