package com.example.erfan_adine_ptest.dto.in.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerOrUserSerchInDto {
    String fName;
    String lName;
    String Password;
    String email;
    Integer PageNumber;
    Integer PageSize;
}
