package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);
    List<GenericProductDto> getALlProducts();
    GenericProductDto deleteProductById(Long id);
    GenericProductDto addProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProduct(Long id , GenericProductDto genericProductDto);
}
