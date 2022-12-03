package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.model.Factor;
import com.buidit.BuildItBack.model.Product;
import com.buidit.BuildItBack.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> getProducts(){
        return productRepo.findAll();
    }
    public Product addProduct(Product product){
        return productRepo.save(product);
    }
    public Product updateProduct(Product product){
        return productRepo.save(product);
    }
    public void deleteProduct(Integer productId){
        productRepo.deleteById(productId);
    }
    public Product getProductByName(String productName){
        return productRepo.findByProductName(productName);
    }
    public Product getProductByModelNo(String modelNumber){
        return productRepo.findByModelNo(modelNumber);
    }
    public Product getProductByCategoryId(Integer categoryId){
        return productRepo.findByCategoryId(categoryId);
    }
    public Product getProductByPrice(Integer minPrice, Integer maxPrice){
        return productRepo.findByPrice(minPrice,maxPrice);
    }
}
