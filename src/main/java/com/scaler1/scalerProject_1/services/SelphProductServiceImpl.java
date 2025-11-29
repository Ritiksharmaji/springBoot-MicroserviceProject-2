package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.models.Product;
import org.springframework.stereotype.Service;

@Service("selphProductServiceImpl")
public class SelphProductServiceImpl implements  ProductService{


    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}
