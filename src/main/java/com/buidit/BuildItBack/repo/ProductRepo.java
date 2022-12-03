package com.buidit.BuildItBack.repo;

import com.buidit.BuildItBack.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByProductName(String productName);
    Product findByModelNo(String modelNumber);
    Product findByCategoryId(Integer categoryId);
    Product findByPrice(Integer minPrice, Integer maxPrice);
}
