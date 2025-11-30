package com.scaler1.scalerProject_1.thirdpartyclients.productsservice.fakestore;

import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.exceptions.NotFoundException;
import com.scaler1.scalerProject_1.thirdpartyclients.productsservice.ThirdPartyProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.List;

//@Service
//@Configuration
//public class FakeStoreProductServiceClient implements ThirdPartyProductService {
//
//    private  RestClient restClient;
//
//
////    @Value("fakestore.api.url")
////    private String fakeStoreApiCall;
////
////    @Value("fakestore.api.paths.product")
////    private String fakeStoreProductApiPath;
//
//    @Value("${fakestore.api.url}")
//    private String fakeStoreApiCall;
//
//    @Value("${fakestore.api.paths.product}")
//    private String fakeStoreProductApiPath;
//
//
//    private final String specificProductRequestUrl = fakeStoreApiCall + fakeStoreProductApiPath + "/{id}";
//    private final String allProductsUrl = fakeStoreApiCall + fakeStoreProductApiPath;
//
////    private final String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
////    private final String allProductsUrl = "https://fakestoreapi.com/products";
//
//    public FakeStoreProductServiceClient(RestClient restClient) {
//        this.restClient = restClient;
//    }
//
//    // GET PRODUCT BY ID (ResponseEntity)
//    // ================================================
//    @Override
//    public ResponseEntity<FakeStoreProductDto> getProductById(Long id) {
//
//        FakeStoreProductDto product = restClient.get()
//                .uri(specificProductRequestUrl, id)
//                .retrieve()
//                .body(FakeStoreProductDto.class);
//
//        if (product == null) {
//            throw new NotFoundException("Product not found with id: " + id);
//        }
//
//        return ResponseEntity.ok(product);
//    }
//
//    // ================================================
//    // GET ALL PRODUCTS (ResponseEntity)
//    // ================================================
//    @Override
//    public ResponseEntity<List<FakeStoreProductDto>> getALlProducts() {
//        try {
//            FakeStoreProductDto[] products = restClient.get()
//                    .uri(allProductsUrl)
//                    .retrieve()
//                    .body(FakeStoreProductDto[].class);
//
//            if (products == null) {
//                throw new RuntimeException("Failed to fetch all products: Empty response");
//            }
//
//            return ResponseEntity.ok(Arrays.asList(products));
//        }
//        catch (RestClientException e) {
//            throw new RuntimeException("Failed to fetch all products", e);
//        }
//    }
//
//    // ================================================
//    // DELETE PRODUCT (ResponseEntity)
//    // ================================================
//    @Override
//    public ResponseEntity<FakeStoreProductDto> deleteProductById(Long id) {
//        try {
//            FakeStoreProductDto deleted = restClient.delete()
//                    .uri(specificProductRequestUrl, id)
//                    .retrieve()
//                    .body(FakeStoreProductDto.class);
//
//            return ResponseEntity.ok(deleted);
//        }
//        catch (RestClientException e) {
//            throw new RuntimeException("Failed to delete product with ID: " + id, e);
//        }
//    }
//
//    // ================================================
//    // CREATE PRODUCT (ResponseEntity)
//    // ================================================
//    @Override
//    public ResponseEntity<FakeStoreProductDto> addProduct(GenericProductDto genericProductDto) {
//        try {
//            FakeStoreProductDto created = restClient.post()
//                    .uri(allProductsUrl)
//                    .body(genericProductDto)
//                    .retrieve()
//                    .body(FakeStoreProductDto.class);
//
//            return ResponseEntity.ok(created);
//        }
//        catch (RestClientException e) {
//            throw new RuntimeException("Failed to add new product", e);
//        }
//    }
//
//    // ================================================
//    // UPDATE PRODUCT (ResponseEntity)
//    // ================================================
//    @Override
//    public ResponseEntity<FakeStoreProductDto> updateProduct(Long id, GenericProductDto genericProductDto) {
//        try {
//            FakeStoreProductDto updated = restClient.put()
//                    .uri(specificProductRequestUrl, id)
//                    .body(genericProductDto)
//                    .retrieve()
//                    .body(FakeStoreProductDto.class);
//
//            return ResponseEntity.ok(updated);
//        }
//        catch (RestClientException e) {
//            throw new RuntimeException("Failed to update product with ID: " + id, e);
//        }
//    }
//}

@Service
public class FakeStoreProductServiceClient implements ThirdPartyProductService {

    private final RestClient restClient;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiCall;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductApiPath;

    public FakeStoreProductServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }

    private String getProductUrl(Long id) {
        return fakeStoreApiCall + fakeStoreProductApiPath + "/" + id;
    }

    private String getAllProductsUrl() {
        return fakeStoreApiCall + fakeStoreProductApiPath;
    }

    @Override
    public ResponseEntity<FakeStoreProductDto> getProductById(Long id) {

        FakeStoreProductDto product = restClient.get()
                .uri(getProductUrl(id))
                .retrieve()
                .body(FakeStoreProductDto.class);

        if (product == null) throw new NotFoundException("Product not found: " + id);

        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<FakeStoreProductDto>> getALlProducts() {

        FakeStoreProductDto[] products = restClient.get()
                .uri(getAllProductsUrl())
                .retrieve()
                .body(FakeStoreProductDto[].class);

        return ResponseEntity.ok(Arrays.asList(products));
    }

    @Override
    public ResponseEntity<FakeStoreProductDto> deleteProductById(Long id) {

        FakeStoreProductDto deleted = restClient.delete()
                .uri(getProductUrl(id))
                .retrieve()
                .body(FakeStoreProductDto.class);

        return ResponseEntity.ok(deleted);
    }

    @Override
    public ResponseEntity<FakeStoreProductDto> addProduct(GenericProductDto genericProductDto) {

        FakeStoreProductDto created = restClient.post()
                .uri(getAllProductsUrl())
                .body(genericProductDto)
                .retrieve()
                .body(FakeStoreProductDto.class);

        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<FakeStoreProductDto> updateProduct(Long id, GenericProductDto genericProductDto) {

        FakeStoreProductDto updated = restClient.put()
                .uri(getProductUrl(id))
                .body(genericProductDto)
                .retrieve()
                .body(FakeStoreProductDto.class);

        return ResponseEntity.ok(updated);
    }
}
