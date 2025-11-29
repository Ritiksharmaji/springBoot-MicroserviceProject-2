package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.FakeStoreProductDto;
import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<GenericProductDto> getProductById(Long id);
    List<FakeStoreProductDto> getALlProducts();
    GenericProductDto deleteProductById(Long id);
    GenericProductDto addProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProduct(Long id , GenericProductDto genericProductDto);
}
