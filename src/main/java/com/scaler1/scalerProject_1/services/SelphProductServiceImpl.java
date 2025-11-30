package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selphProductServiceImpl")
public class SelphProductServiceImpl implements  ProductService{


    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getALlProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto addProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
