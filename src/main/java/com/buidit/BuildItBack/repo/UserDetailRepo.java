package com.buidit.BuildItBack.repo;

import com.buidit.BuildItBack.model.User;
import com.buidit.BuildItBack.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDetailRepo extends JpaRepository<UserDetail, Integer> {
    List<UserDetail> findByUser(User user);
    public UserDetail findByUserId(Integer user_id);
    Optional<UserDetail> findUserByUserId(Integer userId);
}
