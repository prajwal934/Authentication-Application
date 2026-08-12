package com.substring.auth.app.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.substring.auth.app.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	Optional<User>  findByEmail(String userEmail);
	boolean existsByEmail(String userEmail);

}
