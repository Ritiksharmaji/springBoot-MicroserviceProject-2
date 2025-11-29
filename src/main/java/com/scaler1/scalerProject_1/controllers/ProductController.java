package com.scaler1.scalerProject_1.controllers;

import com.scaler1.scalerProject_1.dtos.ExceptionDto;
import com.scaler1.scalerProject_1.dtos.FakeStoreProductDto;
import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.exceptions.NotFoundException;
import com.scaler1.scalerProject_1.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//    @GetMapping("/{id}")
//    public ResponseEntity<GenericProductDto> getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable Long id) {
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

    // defining a method for NotFound so out-of these any controller will throw the NotFound Exception then it will run
    // and it will return the response to that given request.

//    @ExceptionHandler(NotFoundException.class)
//    private ExceptionDto handleNotFoundException(){
//        System.out.println("Not Found Exception happend in controller");
//
//       // return "Product not found bro with this id";
//        return new ExceptionDto(HttpStatus.NOT_FOUND, "Not Found Product with given Id");
//    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException ex) {
//        System.out.println("Not Found Exception triggered");
//
//        ExceptionDto dto = new ExceptionDto(
//                HttpStatus.NOT_FOUND,
//                ex.getMessage()
//        );
//
//        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
//    }



}
