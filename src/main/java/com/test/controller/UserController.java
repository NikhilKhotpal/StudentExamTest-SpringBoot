package com.test.controller;

import com.test.Service.UserService;
import com.test.studentModel.ChangePasswordRequest;
import com.test.studentModel.UserModel;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping("/Allusers")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/Userbyid/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Add new user
    @PostMapping("/Adduser")
    public ResponseEntity<String>  addUser(@Valid @RequestBody  UserModel user, BindingResult result) {
    	
    	 if(userService.isUserAlreadyRegistered(user.getEmail(),user.getPassword())) {
    		return new ResponseEntity<>("User Alredy Register",HttpStatus.CONFLICT);
    	}
    	
    	
    	userService.addUser(user);
    	
    	return ResponseEntity.ok("success");	
    }
     
    

    // Update user
    @PutMapping("/Update/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel user) {
        user.setId(id);  // Set the ID to ensure we're updating the correct user
        return userService.updateUser(user);
    }

    // Delete user
    @DeleteMapping("/Delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        boolean isChanged = userService.changePassword(request.getEmail(), request.getOldPassword(), request.getNewPassword());
        if (isChanged) {
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to change password");
        }
    }
}
