package com.substring.auth.app.model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "user_id")
	private UUID userId;
	@Column(name = "user_email", unique = true, length = 300)
	private String userEmail;
	@Column(name = "user_name" , length = 500)
	private String userName;
	private String password;
	private String userImage;
	private boolean enable = true;
	private Instant createdAt = Instant.now();
	private Instant updatedAt = Instant.now();
	
//	private Provide
}
