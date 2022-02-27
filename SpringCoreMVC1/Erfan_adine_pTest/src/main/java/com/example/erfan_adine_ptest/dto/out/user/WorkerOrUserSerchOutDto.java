package com.example.erfan_adine_ptest.dto.out.user;

import lombok.*;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
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
