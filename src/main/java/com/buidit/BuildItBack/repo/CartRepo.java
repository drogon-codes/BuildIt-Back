package com.buidit.BuildItBack.repo;

import com.buidit.BuildItBack.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    void deleteByUserId(Integer userId);

    Cart findByUserId(Integer userId);
    Cart findByProductId(Integer productId);
}
