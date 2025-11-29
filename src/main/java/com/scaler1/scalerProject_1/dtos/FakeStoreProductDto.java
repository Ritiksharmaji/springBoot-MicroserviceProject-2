package com.scaler1.scalerProject_1.dtos;

import com.scaler1.scalerProject_1.models.Category;
import lombok.Data;
import lombok.Setter;

@Data
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
