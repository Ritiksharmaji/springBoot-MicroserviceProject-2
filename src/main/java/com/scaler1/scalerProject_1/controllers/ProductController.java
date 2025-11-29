package com.scaler1.scalerProject_1.controllers;

import com.scaler1.scalerProject_1.dtos.GenericProductDto;
import com.scaler1.scalerProject_1.models.Product;
import com.scaler1.scalerProject_1.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
//import dev.naman.productservice.dtos.ExceptionDto;
//import dev.naman.productservice.dtos.GenericProductDto;
//import dev.naman.productservice.dtos.Request;
//import dev.naman.productservice.exceptions.NotFoundException;
//import dev.naman.productservice.security.JwtObject;
//import dev.naman.productservice.security.TokenValidator;
//import dev.naman.productservice.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;
    // to create object for productService object trow the spring boot.
    public ProductController( @Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;

    }

    // basically we can create object in spring boot by 2- ways
    //1) by constructer
    // 2) throw @Autowired also on the filed it selph
    // and out if these two constructer inject is best practies




    // GET all products
    @GetMapping
    public String getAllProducts() {
        return "Returning all products";
    }

    // GET product by id
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        //return "Returning product with ID: " + id;
        return productService.getProductById(id);
    }
    // DELETE -> Delete product
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id) {
        return "Product deleted with ID: " + id;
    }

    // POST -> Create new product
    @PostMapping
    public String createProduct(@RequestBody String product) {
        return "Product created: " + product;
    }

    // PUT -> Update product by id
    @PutMapping("/{id}")
    public String updateProductById(@PathVariable int id, @RequestBody String product) {
        return "Product updated with ID: " + id + " -> " + product;
    }


}

