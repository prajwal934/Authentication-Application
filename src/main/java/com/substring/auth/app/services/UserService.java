package com.substring.auth.app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.substring.auth.app.dto.UserDto;
import com.substring.auth.app.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<UserDto>>  registerUser(UserDto userDto);
	  
	ResponseEntity<ResponseStructure<UserDto>> getUserByEmail(String userEmail);
	
	ResponseEntity<ResponseStructure<UserDto>> updateUser(UserDto userDto, String userId);
	
	ResponseEntity<ResponseStructure<UserDto>> deleteUser(String userId);
	
	ResponseEntity<ResponseStructure<UserDto>>  getUserById(String userId);
	
//	Iterable<UserDto> getAllUser();
	
	public ResponseEntity<ResponseStructure<List<UserDto>>> getAllUsers();
	
}
