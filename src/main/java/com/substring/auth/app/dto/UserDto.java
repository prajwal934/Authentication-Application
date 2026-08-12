package com.substring.auth.app.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.substring.auth.app.model.Provider;
import com.substring.auth.app.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
	

	private UUID userId;
	private String userEmail;
	private String userName;
	private String password;
	private String userImage;
	private boolean enable = true;
	private Instant createdAt = Instant.now();
	private Instant updatedAt = Instant.now();
	
	private Provider provider = Provider.LOCAL;
	
	private Set<RoleDto> roles = new HashSet<>();
	


}
