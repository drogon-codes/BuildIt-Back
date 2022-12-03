package com.buidit.BuildItBack.repo;

import com.buidit.BuildItBack.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String categoryName);

    Category findByBrandId(Integer brandId);
}
