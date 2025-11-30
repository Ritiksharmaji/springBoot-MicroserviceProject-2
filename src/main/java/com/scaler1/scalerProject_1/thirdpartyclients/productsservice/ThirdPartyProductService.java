package com.scaler1.scalerProject_1.thirdpartyclients.productsservice;

import com.scaler1.scalerProject_1.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ThirdPartyProductService {

    ResponseEntity<FakeStoreProductDto> getProductById(Long id);

    ResponseEntity<List<FakeStoreProductDto>> getALlProducts();

    ResponseEntity<FakeStoreProductDto> deleteProductById(Long id);

    ResponseEntity<FakeStoreProductDto> addProduct(GenericProductDto genericProductDto);

    ResponseEntity<FakeStoreProductDto> updateProduct(Long id, GenericProductDto genericProductDto);
}
