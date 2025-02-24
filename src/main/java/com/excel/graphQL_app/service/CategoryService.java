package com.excel.graphQL_app.service;

import com.excel.graphQL_app.model.Category;
import com.excel.graphQL_app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(String name) {
        if (categoryRepository.existsByNameIgnoreCase(name)) {
            throw new IllegalArgumentException("Category already exists");
        }

        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, String name) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        category.setName(name);
        return categoryRepository.save(category);
    }

    public boolean deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        if (!category.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Cannot delete category with existing products");
        }

        categoryRepository.deleteById(id);
        return true;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findByName(String categoryName) {
        return categoryRepository.findByNameIgnoreCase(categoryName);
    }

    public Category findById(Long id) { return categoryRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("Category not found"));
    }
}
