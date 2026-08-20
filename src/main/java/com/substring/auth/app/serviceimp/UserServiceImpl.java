package com.substring.auth.app.serviceimp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.substring.auth.app.dto.UserDto;
import com.substring.auth.app.model.Provider;
import com.substring.auth.app.model.User;
import com.substring.auth.app.repository.UserRepository;
import com.substring.auth.app.services.UserService;
import com.substring.auth.app.utility.ResponseStructure;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	private final ResponseStructure<UserDto> responseStructure;
	private final ResponseStructure<List<UserDto>> rs;
	
	@Override
	public ResponseEntity<ResponseStructure<UserDto>> registerUser(UserDto userDto) {
		// TODO Auto-generated method stub
		if(userDto.getUserEmail() == null || userDto.getUserEmail().isBlank()) {
			throw new IllegalArgumentException("Email is Required");
		}
		
		if(userRepository.existsByUserEmail(userDto.getUserEmail())) {
			throw new IllegalArgumentException("Email already exist!");
		}
		
		User user = modelMapper.map(userDto, User.class);
		user.setProvider(userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL);
		
		//TODO: Role assign to user for authorization
		User savedUser = userRepository.save(user);
		
		UserDto responseUser = modelMapper.map(savedUser, UserDto.class);
		ResponseStructure<UserDto> rs = new ResponseStructure<>();
		rs.setData(responseUser);
		return ResponseEntity.ok(rs.setStatusCode(HttpStatus.OK.value())
				.setMessage("User Data Registered Successfully!")
				.setData(responseUser));
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

	@Override
	public ResponseEntity<ResponseStructure<UserDto>> getUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<UserDto>>> getAllUsers() {

	    List<UserDto> users = userRepository.findAll()
	            .stream()
	            .map(user -> modelMapper.map(user, UserDto.class))
	            .toList();

	    return ResponseEntity.ok(
	            rs.setStatusCode(HttpStatus.OK.value())
	              .setMessage("Users Data Fetched Successfully!")
	              .setData(users)
	    );
	}

	

	
}
