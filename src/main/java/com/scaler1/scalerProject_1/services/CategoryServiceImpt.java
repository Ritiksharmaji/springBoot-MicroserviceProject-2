package com.scaler1.scalerProject_1.services;

import com.scaler1.scalerProject_1.dtos.CategoryDto;
import com.scaler1.scalerProject_1.dtos.PriceDto;
import com.scaler1.scalerProject_1.dtos.ProductDto;
import com.scaler1.scalerProject_1.models.Category;
import com.scaler1.scalerProject_1.models.Product;
import com.scaler1.scalerProject_1.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class CategoryServiceImpt implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImpt(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

//    @Override
//    public Category getCategory(String id) {
//        Long categoryId = Long.parseLong(id);
//        return categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new RuntimeException("Category not found"));
//    }

// ========== other ========================

//    @Override
//    public CategoryDto getCategory(String id) {
//        Long categoryId = Long.parseLong(id);
//
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new RuntimeException("Category not found"));
//
//        return convertToDto(category);
//    }
//
//    private CategoryDto convertToDto(Category category) {
//        CategoryDto dto = new CategoryDto();
//        dto.setId(category.get);
//        dto.setName(category.getName());
//        return dto;
//    }

  // ----------------------- other ----------
  @Override
  public CategoryDto getCategory(String id) {

      Long categoryId = Long.parseLong(id);

      Category category = categoryRepository.findById(categoryId)
              .orElseThrow(() -> new RuntimeException("Category not found"));

      return convertToDto(category);
  }

  private CategoryDto convertToDto(Category category) {
      CategoryDto dto = new CategoryDto();
      dto.setId(category.getId());
      dto.setName(category.getName());

      dto.setProducts(
              category.getProducts().stream()
                      .map(this::convertProductToDto)
                      .collect(Collectors.toList())
      );

      return dto;
  }

    private ProductDto convertProductToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setImage(product.getImage());

        if (product.getPrice() != null) {
            PriceDto priceDto = new PriceDto();
            priceDto.setId(product.getPrice().getId());
            priceDto.setCurrency(product.getPrice().getCurrency());
            priceDto.setPrice(product.getPrice().getPrice());
            dto.setPrice(priceDto);
        }

        return dto;
    }
}
