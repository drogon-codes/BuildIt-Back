package com.buidit.BuildItBack.restresource;

import com.buidit.BuildItBack.model.User;
import com.buidit.BuildItBack.model.UserDetail;
import com.buidit.BuildItBack.service.UserDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDetail")
public class UserDetailResource {
    private final UserDetailService userDetailService;

    public UserDetailResource(UserDetailService userDetailService){
        this.userDetailService = userDetailService;
    }

    @GetMapping("/allUserDetails")
    public ResponseEntity<List<UserDetail>> getAllUserDetails(){
        List<UserDetail> userDetails = userDetailService.getAllUserDetails();
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @GetMapping("/find/{userDetailId}")
    public ResponseEntity<UserDetail> getUserDetailsById(@PathVariable("userDetailId") Integer userDetailId){
        UserDetail userDetails = userDetailService.findUserDetailById(userDetailId);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @PutMapping("/addUserDetails")
    public ResponseEntity<UserDetail> addUser(@RequestBody UserDetail userDetail){
        UserDetail userDetail1 = userDetailService.addUserDetail(userDetail);
        return new ResponseEntity<>(userDetail1, HttpStatus.OK);
    }

    @PutMapping("/updateUserDetails")
    public ResponseEntity<UserDetail> updateUser(@RequestBody UserDetail userDetail){
        UserDetail userDetail1 = userDetailService.updateUserDetail(userDetail);
        return new ResponseEntity<>(userDetail1, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserDetails/{userDetailId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userDetailId") Integer userDetailId){
        userDetailService.deleteUserDetail(userDetailId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findByUserId")
    public ResponseEntity<UserDetail> getUserDetailsByUserId(@PathVariable("user_id") Integer user_id){
        UserDetail userDetail = userDetailService.findByUserId(user_id);
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }
}
