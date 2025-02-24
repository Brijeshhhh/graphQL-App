
package com.excel.graphQL_app.repository;

import com.excel.graphQL_app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByNameIgnoreCase(String name);

    Category findByNameIgnoreCase(String categoryName);
}