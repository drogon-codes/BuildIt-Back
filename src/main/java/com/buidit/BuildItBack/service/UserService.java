package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.User;
import com.buidit.BuildItBack.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    SecureRandom secureRandom = new SecureRandom();
    byte[] salt = secureRandom.generateSeed(12);
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String pass = user.getPassword();

        PBEKeySpec pbeKeySpec = new PBEKeySpec(pass.toCharArray(), salt, 10, 512);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = skf.generateSecret(pbeKeySpec).getEncoded();

        //converting to string to store into database
        String base64Hash = Base64.getMimeEncoder().encodeToString(hash);
        user.setPassword(base64Hash);
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Integer userId){
        userRepo.deleteById(userId);
    }

    public User findUserById(Integer userId){
        return userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User by id " + userId + " was not found"));
    }

    public User login(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String input = user.getPassword();
        String username = user.getUserName();
//        PBEKeySpec pbeKeySpec2 = new PBEKeySpec(input.toCharArray(), salt, 10, 512);
//        SecretKeyFactory skf2 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
//        byte[] hash2 = skf2.generateSecret(pbeKeySpec2).getEncoded();
//
//        String base64Hash2 = Base64.getMimeEncoder().encodeToString(hash2);
//        return base64Hash2;
        return userRepo.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

//    public void deleteUser1(Integer userId){
//        userRepo.deleteUserByUserId(userId);
//    }
//
//    public User findUserById1(Integer userId){
//        return userRepo.findUserByUserId(userId).orElseThrow(() -> new UserNotFoundException("User by id " + userId + " was not found"));
//    }
}
