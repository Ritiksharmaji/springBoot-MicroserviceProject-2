package com.scaler1.scalerProject_1.controllers;

import com.scaler1.scalerProject_1.dtos.CategoryDto;
import com.scaler1.scalerProject_1.models.Category;
import com.scaler1.scalerProject_1.services.CategoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;

    }
    // by maintaing
//    @RequestMapping("/{id}")
//    public Category getCategory(@PathVariable String id){
//
//        return categoryService.getCategory(id);
//    }
    @RequestMapping("/{id}")
    public CategoryDto getCategory(@PathVariable String id){

        return categoryService.getCategory(id);
    }

}
