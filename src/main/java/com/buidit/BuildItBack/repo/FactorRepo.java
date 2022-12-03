package com.buidit.BuildItBack.repo;

import com.buidit.BuildItBack.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactorRepo extends JpaRepository<Factor, Integer> {
    Factor findByFactorName(String factorName);
}
