package com.example.erfan_adine_ptest.dto.out.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointsCommetnsOutDto {
    private List<Integer> point;
}
