package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.FakeStoreProductDto;
import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.io.NotActiveException;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServices implements ProductService {

    private final RestClient restClient;

    public FakeStoreProductServices() {
        this.restClient = RestClient.builder()
                .baseUrl("https://fakestoreapi.com")
                .build();
    }

    // ================================================
    // GET PRODUCT BY ID
    // ================================================
//    @Override
//    public GenericProductDto getProductById(Long id) {
//        try {
//            return restClient.get()
//                    .uri("/products/" + id)
//                    .retrieve()
//                    .body(GenericProductDto.class);
//        }
//        catch (RestClientException e) {
//            throw new RuntimeException("Failed to fetch product with ID: " + id, e);
//        }
//    }
    // =====================================
//    public GenericProductDto getProductById(Long id) throws NotFoundException {
//        GenericProductDto response = restClient.get()
//                .uri("/products/" + id)
//                .retrieve()
//                .body(GenericProductDto.class);
//        if(response == null){
//            throw new NotFoundException("Product with id:"+id+"not found");
//        }
//        else{
//            return response;
//        }
//
//    }

//    @Override
//    public ResponseEntity<GenericProductDto> getProductById(Long id) {
//        try {
//            GenericProductDto response = restClient.get()
//                    .uri("/products/" + id)
//                    .retrieve()
//                    .body(GenericProductDto.class);
//
//            if (response == null) {
//                throw new NotFoundException("Product with ID " + id + " not found");
//            }
//
//            return ResponseEntity.ok(response);  // CORRECT
//
//        } catch (RestClientException e) {
//            throw new NotFoundException("Product with ID " + id + " not found");
//        }
//    }

    // with global exception handler
    public ResponseEntity<GenericProductDto> getProductById(Long id) {
        GenericProductDto product = restClient.get()
                .uri("/products/" + id)
                .retrieve()
                .body(GenericProductDto.class);

        if (product == null) {
            throw new NotFoundException("Product not found with id: " + id);
        }

        return ResponseEntity.ok(product);
    }



    // ================================================
    // GET ALL PRODUCTS
    // ================================================
    @Override
    public List<FakeStoreProductDto> getALlProducts() {
        try {
            FakeStoreProductDto[] products = restClient.get()
                    .uri("/products")
                    .retrieve()
                    .body(FakeStoreProductDto[].class);

            if (products == null) {
                throw new RuntimeException("Failed to fetch all products: Empty response");
            }

            return Arrays.asList(products);
        }
        catch (RestClientException e) {
            throw new RuntimeException("Failed to fetch all products", e);
        }
    }

    // ================================================
    // DELETE PRODUCT
    // ================================================
    @Override
    public GenericProductDto deleteProductById(Long id) {
        try {
            return restClient.delete()
                    .uri("products/" + id)
                    .retrieve()
                    .body(GenericProductDto.class);
        }
        catch (RestClientException e) {
            throw new RuntimeException("Failed to delete product with ID: " + id, e);
        }
    }

    // ================================================
    // CREATE / ADD PRODUCT
    // ================================================
    @Override
    public GenericProductDto addProduct(GenericProductDto genericProductDto) {
        try {
            return restClient.post()
                    .uri("products")
                    .body(genericProductDto)
                    .retrieve()
                    .body(GenericProductDto.class);
        }
        catch (RestClientException e) {
            throw new RuntimeException("Failed to add new product", e);
        }
    }

    // ================================================
    // UPDATE PRODUCT
    // ================================================
    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        try {
            return restClient.put()
                    .uri("products/" + id)
                    .body(genericProductDto)
                    .retrieve()
                    .body(GenericProductDto.class);
        }
        catch (RestClientException e) {
            throw new RuntimeException("Failed to update product with ID: " + id, e);
        }
    }
}
