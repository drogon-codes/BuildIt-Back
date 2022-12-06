package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.*;
import com.buidit.BuildItBack.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    SecureRandom secureRandom = new SecureRandom();
    byte[] salt = secureRandom.generateSeed(12);
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String pass = user.getPassword();

//        PBEKeySpec pbeKeySpec = new PBEKeySpec(pass.toCharArray(), salt, 10, 512);
//        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
//        byte[] hash = skf.generateSecret(pbeKeySpec).getEncoded();
//
//        //converting to string to store into database
//        String base64Hash = Base64.getMimeEncoder().encodeToString(hash);
//        user.setPassword(base64Hash);
        user.setPassword(passwordEncoder.encode(pass));
        return userRepo.save(user);
    }

    public String findUser(User user){
        String email = user.getEmail();
        String raw = user.getPassword();
        if(email!=""){
            User u = userRepo.findByEmail(email).orElseThrow(() ->
                    new UsernameNotFoundException("User not found"));
            String firm = u.getPassword();
            if(u!=null){
                Boolean pass = passwordEncoder.matches(raw,firm);
                if(pass==true){
                    return "Credentials Found";
                }
                else{
                    return "Credentials Dismissed";
                }
            }
        }
        return "true";
    }
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User existingUser = userRepo.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        String pass = existingUser.getPassword();

        return new org.springframework.security.core.userdetails.User(
                existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
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
