package com.scaler1.scalerProject_1.dtos;

import lombok.Data;

@Data
public class PriceDto {
    private Long id;
    private String currency;
    private Double price;
}
