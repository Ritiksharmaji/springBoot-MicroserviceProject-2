package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.FakeStoreProductDto;
import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

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
    @Override
    public GenericProductDto getProductById(Long id) {
        try {
            GenericProductDto genericProductDto = restClient.get()
                    .uri("/product/" + id)
                    .retrieve()
                    .body(GenericProductDto.class);

            // Check if value exists
            if (genericProductDto != null) {
                return genericProductDto;
            } else {
                throw new RuntimeException("No value found for product ID: " + id);
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to fetch product with ID: " + id, e);
        }
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
//    @Override
//    public GenericProductDto deleteProductById(Long id) {
//        try {
//            return restClient.delete()
//                    .uri("products/" + id)
//                    .retrieve()
//                    .body(GenericProductDto.class);
//        }
//        catch (RestClientException e) {
//            throw new RuntimeException("Failed to delete product with ID: " + id, e);
//        }
//    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        try {
            GenericProductDto deletedProduct = restClient.delete()
                    .uri("/products/" + id)
                    .retrieve()
                    .body(GenericProductDto.class);

            // If API returns something, return it
            if (deletedProduct != null) {
                return deletedProduct;
            } else {
                throw new RuntimeException("No product found to delete with ID: " + id);
            }

        } catch (RestClientException e) {
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
