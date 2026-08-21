package com.substring.auth.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.substring.auth.app.dto.UserDto;
import com.substring.auth.app.services.UserService;
import com.substring.auth.app.utility.ResponseStructure;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>> registerUser(@RequestBody UserDto userDto) {
		return userService.registerUser(userDto);
	}
	
	//TODO: For getting all the users
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<UserDto>>>  getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/email/{userEmail}")
	public ResponseEntity<ResponseStructure<UserDto>> getUserByEmail(@PathVariable("userEmail") String userEmail) {
		return userService.getUserByEmail(userEmail);
	}
}
