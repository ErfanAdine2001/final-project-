package com.example.erfan_adine_ptest.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCardInformationInDto {

    //TODO @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ new dto
    @Pattern(regexp = "\\W*\\d{8,17}\\b")
    private Integer accountNumber;

    private BigDecimal balance;


//
//    public Boolean checkAccountNumber(){
//        if ()
//    }
}
