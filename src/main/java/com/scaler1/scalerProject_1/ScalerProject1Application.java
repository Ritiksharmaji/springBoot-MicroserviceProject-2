package com.scaler1.scalerProject_1;

import com.scaler1.scalerProject_1.inheritanceDemo.SingleTable.*;
import com.scaler1.scalerProject_1.inheritanceDemo.Joined.*;
import com.scaler1.scalerProject_1.inheritanceDemo.TablePerClass.*;
import com.scaler1.scalerProject_1.inheritanceDemo.MappedSuperClass.*;
import com.scaler1.scalerProject_1.models.Category;
import com.scaler1.scalerProject_1.models.Price;
import com.scaler1.scalerProject_1.models.Product;
import com.scaler1.scalerProject_1.repositories.CategoryRepository;
import com.scaler1.scalerProject_1.repositories.PriceRepository;
import com.scaler1.scalerProject_1.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScalerProject1Application implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    // ------------------- Cardinality mappings ----------------

    public ScalerProject1Application(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ScalerProject1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // ===================== Cardinality mappings ========
        Category category = new Category();
        category.setName("cloths");
      // Category saveCategory = categoryRepository.save(category);

        Price price = new Price("repuess",900);
        price.setPrice(6000);
      // Price savePricce =  priceRepository.save(price);

        Product product = new Product();
        product.setTitle("old Product");
//        product.setPrice(savePricce);
        product.setPrice(price);
        product.setDescription("this is one of important book for developer");
        product.setImage("/cloudnary/ritik/product/34");
//        product.setCategory(saveCategory);
        product.setCategory(category);
        productRepository.save(product);

       Product titleProduct =  productRepository.findByTitleEquals("Ritik");
       System.out.println("finded title is :"+ titleProduct);


    }
}
