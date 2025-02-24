//package com.excelacom.graphQL_demo.config;
//
//import com.excelacom.graphQL_demo.model.Category;
//import com.excelacom.graphQL_demo.model.Product;
//import com.excelacom.graphQL_demo.repository.CategoryRepository;
//import com.excelacom.graphQL_demo.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public void run(String... args) {
//        Category wireless = new Category();
//        wireless.setName("wireless");
//        wireless.setProducts(new ArrayList<>());
//        wireless = categoryRepository.save(wireless);
//
//        Product wifi = new Product();
//        wifi.setName("wifi");
//        wifi.setPrice("1000");
//        wifi.setCategory(wireless);
//        productRepository.save(wifi);
//
//        Product wifi5 = new Product();
//        wifi5.setName("wifi5");
//        wifi5.setPrice("5000");
//        wifi5.setCategory(wireless);
//        productRepository.save(wifi5);
//    }
//}