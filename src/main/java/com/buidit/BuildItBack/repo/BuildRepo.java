package com.buidit.BuildItBack.repo;

import com.buidit.BuildItBack.model.Build;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildRepo extends JpaRepository<Build, Integer> {
    Build findByUserId(Integer userId);
}
