package com.scaler1.scalerProject_1.dtos;

import com.scaler1.scalerProject_1.models.Category;
import lombok.Data;

@Data
public class GenericProductDto  {

    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
