package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.Factor;
import com.buidit.BuildItBack.repo.FactorRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FactorService {
    private final FactorRepo factorRepo;
    @Autowired
    public FactorService(FactorRepo factorRepo) {
        this.factorRepo = factorRepo;
    }
    public List<Factor> getFactor(){
        return factorRepo.findAll();
    }
    public Factor addFactor(Factor factor){
        return factorRepo.save(factor);
    }
    public Factor updateFactor(Factor factor){
        return factorRepo.save(factor);
    }
    public void deleteFactor(Integer factorId){
        factorRepo.deleteById(factorId);
    }
    public Factor getFactorByName(String factorName){
        return factorRepo.findByFactorName(factorName);
    }
    public Factor findByFactorId(Integer factorId){
        return factorRepo.findById(factorId).orElseThrow(() -> new UserNotFoundException("Factor by id " + factorId + " was not found"));
    }
}
