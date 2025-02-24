package com.excel.graphQL_app.resolver;

import com.excel.graphQL_app.model.Category;
import com.excel.graphQL_app.model.Product;
import com.excel.graphQL_app.service.CategoryService;
import com.excel.graphQL_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MutationResolver {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @MutationMapping
    public Product createProduct(@Argument String name, @Argument String price, @Argument Long categoryId) {
        return productService.createProduct(name, price, categoryId);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument String name, @Argument String price, @Argument Long categoryId) {
        return productService.updateProduct(id, name, price, categoryId);
    }

    @MutationMapping
    public boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }

    @MutationMapping
    public Category createCategory(@Argument String name) {
        return categoryService.createCategory(name);
    }

    @MutationMapping
    public Category updateCategory(@Argument Long id, @Argument String name) {
        return categoryService.updateCategory(id, name);
    }

    @MutationMapping
    public boolean deleteCategory(@Argument Long id) {
        return categoryService.deleteCategory(id);
    }
}