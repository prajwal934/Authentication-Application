package com.substring.auth.app.serviceimp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.substring.auth.app.dto.UserDto;
import com.substring.auth.app.services.UserService;
import com.substring.auth.app.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public ResponseEntity<ResponseStructure<UserDto>> registerUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<UserDto>> getUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(UserDto userDto, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
