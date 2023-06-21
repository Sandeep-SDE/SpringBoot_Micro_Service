package com.micro.category.service.controller;

import com.micro.category.service.entity.Category;
import com.micro.category.service.service_provider.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{categoryId}")
    public Optional<Category> findByCategoryId(@PathVariable int categoryId){
        return categoryService.findByCategoryId(categoryId);
    }

    @GetMapping
    public List<Category> findAllCategories(){
        return categoryService.findAllCategories();
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category){
        category.setCategoryId(id);
        return categoryService.updateByCategoryId(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.deleteByCategoryId(id);
        return "Category is deleted successfully"+ id;
    }

}
