package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service("fakeStoreProductService")
public class FakeStoreProductServices implements ProductService {

    private final RestClient restClient;

    public FakeStoreProductServices() {
        this.restClient = RestClient.builder()
                .baseUrl("https://fakestoreapi.com")
                .build();
    }

    @Override
    public GenericProductDto getProductById(Long id) {

//        Product product = restClient.get()
//                .uri("/products/" + id)
//                .retrieve()
//                .body(Product.class);
        GenericProductDto product = restClient.get()
                .uri("/products/" + id)
                .retrieve()
                .body(GenericProductDto.class);

        System.out.println("Fetched Product = " + product);

        return product;
    }
}
