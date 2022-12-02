package com.buidit.BuildItBack.repo;

import com.buidit.BuildItBack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    void deleteUserByUserId(Integer userId);
    Optional<User> findUserByUserId(Integer userId);

    @Query("select u from User u")
    Optional<User> findUserByUsername(String username);


}
