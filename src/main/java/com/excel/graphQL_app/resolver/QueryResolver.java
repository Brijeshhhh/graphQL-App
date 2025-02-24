package com.excel.graphQL_app.resolver;

import com.excel.graphQL_app.model.Category;
import com.excel.graphQL_app.model.Product;
import com.excel.graphQL_app.service.CategoryService;
import com.excel.graphQL_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class QueryResolver {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @QueryMapping
    public List<Product> productByName(@Argument String productName) {
        return productService.findByName(productName);
    }

    @QueryMapping
    public Category categoryByName(@Argument String categoryName){
        return categoryService.findByName(categoryName);
    }
    @QueryMapping
    public Product productById(@Argument Long id) {
        return productService.findById(id);
    }

    @QueryMapping
    public Category categoryById(@Argument Long id){ return categoryService.findById(id);}
    @QueryMapping
    public List<Category> allCategories() {
        return categoryService.findAll();
    }

     @QueryMapping
    public List<Product> allProducts(){return productService.findAll();}
}
