package com.buidit.BuildItBack.service;

import com.buidit.BuildItBack.exception.UserNotFoundException;
import com.buidit.BuildItBack.model.*;
import com.buidit.BuildItBack.repo.UserDetailRepo;
import com.buidit.BuildItBack.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService {
    private final UserDetailRepo userDetailRepo;
    private final UserRepo userRepo;
    @Autowired
    public UserDetailService(UserDetailRepo userDetailRepo, UserRepo userRepo) {
        this.userDetailRepo = userDetailRepo;
        this.userRepo = userRepo;
    }

    public UserDetail addUserDetail(UserDetail userDetail){
        return userDetailRepo.save(userDetail);
    }

    public List<UserDetail> getAllUserDetails(){
        return userDetailRepo.findAll();
    }

    public UserDetail updateUserDetail(UserDetail userDetail){
        return userDetailRepo.save(userDetail);
    }

    public  void deleteUserDetail(Integer userDetailId){
        userDetailRepo.deleteById(userDetailId);
    }

    public UserDetail findUserDetailById(Integer userDetailId){
        return userDetailRepo.findById(userDetailId).orElseThrow(() -> new UserNotFoundException("User by id " + userDetailId + " was not found"));
    }

//    public  UserDetail findUserByUser(User user){
//        return (UserDetail) userDetailRepo.findByUser(user);
//    }

    public UserDetail findByUserId(Integer userId){
        return userDetailRepo.findByUserId(userId);
    }

}
