package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.models.Product;

public interface ProductService {
    GenericProductDto getProductById(Long id);
}
