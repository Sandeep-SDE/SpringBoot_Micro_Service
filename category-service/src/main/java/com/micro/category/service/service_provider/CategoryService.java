package com.micro.category.service.service_provider;

import com.micro.category.service.entity.Category;
import com.micro.category.service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> findByCategoryId(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public List<Category> findAllCategories() {
        return  categoryRepository.findAll();
    }

    public Category updateByCategoryId(int id, Category category) {
        return categoryRepository.save(category);
    }

    public void deleteByCategoryId(int id) {
        categoryRepository.deleteById(id);
    }
}
