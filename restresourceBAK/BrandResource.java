package com.buidit.BuildItBack.restresource;

import com.buidit.BuildItBack.model.Brand;
//import com.buidit.BuildItBack.model.UserDetail;
import com.buidit.BuildItBack.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandResource {
    private final BrandService brandService;

    public BrandResource(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/allBrands")
    public ResponseEntity<List<Brand>> getAllBrands(){
        List<Brand> brands = brandService.getAllBrands();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @GetMapping("/find/{brandId}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("brandId") Integer brandId){
        Brand brand = brandService.findByBrandId(brandId);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping("/addBrand")
    public ResponseEntity<Brand> addBrand(@RequestBody Brand brand){
        Brand brand1 = brandService.addBrand(brand);
        return new ResponseEntity<>(brand1, HttpStatus.OK);
    }

    @PutMapping("/updateBrand")
    public ResponseEntity<Brand> updateUser(@RequestBody Brand brand){
        Brand brand1 = brandService.updateBrand(brand);
        return new ResponseEntity<>(brand1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBrand/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable("brandId") Integer brandId){
        brandService.deleteBrand(brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByName/{brandName}")
    public ResponseEntity<Brand> getBrandByName(@PathVariable("brandName") String brandName){
        Brand brand = brandService.searchByBrandName(brandName);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }
}
