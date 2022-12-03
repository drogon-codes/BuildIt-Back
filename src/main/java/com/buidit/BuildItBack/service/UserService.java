package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.*;
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

    public User findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }

}
