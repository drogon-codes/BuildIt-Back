package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.Cart;
import com.buidit.BuildItBack.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartService {
    private final CartRepo cartRepo;
    @Autowired
    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }
    public List<Cart> getCart(){
        return cartRepo.findAll();
    }
    public Cart addCart(Cart cart){
        return cartRepo.save(cart);
    }
    public Cart updateCart(Cart cart){
        return cartRepo.save(cart);
    }
    public void deleteCart(Integer cartId){
        cartRepo.deleteById(cartId);
    }

    public void deleteCartByUserId(Integer userId){
        cartRepo.deleteByUserId(userId);
    }

    public Cart findCartByUserId(Integer userId){
        return cartRepo.findByUserId(userId);
    }

    public Cart findCartByProductId(Integer productId){
        return cartRepo.findByProductId(productId);
    }

    public Cart findCartById(Integer cartId){
        return cartRepo.findById(cartId).orElseThrow(() -> new UserNotFoundException("Cart by id " + cartId + " was not found"));
    }

}
