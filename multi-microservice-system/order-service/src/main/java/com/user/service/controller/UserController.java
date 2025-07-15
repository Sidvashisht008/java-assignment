package com.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entity.UserEntity;
import com.user.service.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(UserController.API)
public class UserController {

	
	public static final String API = "/user";
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
        this.userService = userService;
    }
	
	// Create User
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserEntity user){
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
	}
	
	
	// Get User
	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getUser(@PathVariable Long userId){
		return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	// Delete User
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		return new ResponseEntity<>(userService.deleteUserById(userId),HttpStatus.OK);
	}
	
	
	// Update user
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity user){
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
	}
}
