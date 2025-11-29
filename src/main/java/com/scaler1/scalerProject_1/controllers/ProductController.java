package com.scaler1.scalerProject_1.controllers;

import com.scaler1.scalerProject_1.dtos.FakeStoreProductDto;
import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    // Constructor Injection (Best Practice)
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    // -------------------------------------------------------------
    // GET ALL PRODUCTS
    // -------------------------------------------------------------
    @GetMapping
    public List<FakeStoreProductDto> getAllProducts() {
        return productService.getALlProducts();
    }

    // -------------------------------------------------------------
    // GET PRODUCT BY ID
    // -------------------------------------------------------------
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    // -------------------------------------------------------------
    // CREATE PRODUCT (POST)
    // -------------------------------------------------------------
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.addProduct(genericProductDto);
    }

    // -------------------------------------------------------------
    // UPDATE PRODUCT (PUT)
    // -------------------------------------------------------------
    @PutMapping("/{id}")
    public GenericProductDto updateProduct(
            @PathVariable("id") Long id,
            @RequestBody GenericProductDto genericProductDto
    ) {
        return productService.updateProduct(id, genericProductDto);
    }

    // -------------------------------------------------------------
    // DELETE PRODUCT
    // -------------------------------------------------------------
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }
}
