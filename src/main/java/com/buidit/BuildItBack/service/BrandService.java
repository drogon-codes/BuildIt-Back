package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.Brand;
//import com.buidit.BuildItBack.model.User;
import com.buidit.BuildItBack.repo.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepo brandRepo;

    @Autowired
    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }

    public Brand addBrand(Brand brand){
        return brandRepo.save(brand);
    }

    public List<Brand> getAllBrands(){
        return brandRepo.findAll();
    }

    public Brand updateBrand(Brand brand){
        return brandRepo.save(brand);
    }

    public void deleteBrand(Integer brandId){
        brandRepo.deleteById(brandId);
    }

    public Brand findByBrandId(Integer brandId){
        return brandRepo.findById(brandId).orElseThrow(() -> new UserNotFoundException("Brand by id " + brandId + " was not found"));
    }

    public Brand searchByBrandName(String brandName){
        return brandRepo.findByBrandName(brandName);
    }
}
