package com.excel.graphQL_app.service;

import com.excel.graphQL_app.model.Product;
import com.excel.graphQL_app.model.Category;
import com.excel.graphQL_app.repository.ProductRepository;
import com.excel.graphQL_app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct(String name, String price, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, String name, String price, Long categoryId) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);

        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found");
        }
        productRepository.deleteById(id);
        return true;
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameIgnoreCase(name);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public List<Product> findAll() { return productRepository.findAll();
    }
}
