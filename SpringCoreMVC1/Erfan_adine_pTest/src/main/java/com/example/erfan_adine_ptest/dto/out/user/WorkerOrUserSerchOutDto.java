package com.example.erfan_adine_ptest.dto.out.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerOrUserSerchOutDto {
    String fName;
    String lName;
    String Password;
    String email;
    Integer PageNumber;
    Integer PageSize;
}
