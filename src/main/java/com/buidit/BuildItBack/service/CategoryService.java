package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.Category;
import com.buidit.BuildItBack.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    private final CategoryRepo categoryRepo;
    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    public List<Category> getCategory(){
        return categoryRepo.findAll();
    }
    public Category addCategory(Category category){
        return categoryRepo.save(category);
    }
    public Category updateCategory(Category category){
        return categoryRepo.save(category);
    }
    public void deleteCategory(Integer categoryId){
        categoryRepo.deleteById(categoryId);
    }
    public Category findByCategoryId(Integer categoryId){
        return categoryRepo.findById(categoryId).orElseThrow(() -> new UserNotFoundException("Category by id " + categoryId + " was not found"));
    }
    public Category findByCategoryName(String categoryName){
        return categoryRepo.findByCategoryName(categoryName);
    }
    public Category findByBrandId(Integer brandId){
        return categoryRepo.findByBrandId(brandId);
    }
}
