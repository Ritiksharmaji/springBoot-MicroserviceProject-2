package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductServices implements ProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductServices(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    // CONVERTER
    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fake) {
        GenericProductDto product = new GenericProductDto();
        product.setImage(fake.getImage());
        product.setDescription(fake.getDescription());
        product.setTitle(fake.getTitle());
        product.setPrice(fake.getPrice());
        product.setCategory(fake.getCategory());
        return product;
    }

    // =======================
    // GET PRODUCT BY ID
    // =======================
    @Override
    public GenericProductDto getProductById(Long id) {

        ResponseEntity<FakeStoreProductDto> response =
                fakeStoreProductServiceClient.getProductById(id);

        FakeStoreProductDto fakeProduct = response.getBody();  // FIXED ✔

        return convertFakeStoreProductIntoGenericProduct(fakeProduct);
    }

    // =======================
    // GET ALL PRODUCTS
    // =======================
    @Override
    public List<GenericProductDto> getALlProducts() {

        ResponseEntity<List<FakeStoreProductDto>> response =
                fakeStoreProductServiceClient.getALlProducts();

        List<FakeStoreProductDto> fakeProducts = response.getBody(); // FIXED ✔

        return fakeProducts.stream()
                .map(this::convertFakeStoreProductIntoGenericProduct)
                .collect(Collectors.toList()).reversed();
    }

    // =======================
    // DELETE PRODUCT
    // =======================
    @Override
    public GenericProductDto deleteProductById(Long id) {

        ResponseEntity<FakeStoreProductDto> response =
                fakeStoreProductServiceClient.deleteProductById(id);

        return convertFakeStoreProductIntoGenericProduct(response.getBody());
    }

    // =======================
    // ADD PRODUCT
    // =======================
    @Override
    public GenericProductDto addProduct(GenericProductDto genericProductDto) {

        ResponseEntity<FakeStoreProductDto> response =
                fakeStoreProductServiceClient.addProduct(genericProductDto);

        return convertFakeStoreProductIntoGenericProduct(response.getBody());
    }

    // =======================
    // UPDATE PRODUCT
    // =======================
    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {

        ResponseEntity<FakeStoreProductDto> response =
                fakeStoreProductServiceClient.updateProduct(id, genericProductDto);

        return convertFakeStoreProductIntoGenericProduct(response.getBody());
    }
}
