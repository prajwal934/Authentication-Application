package com.substring.auth.app.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.substring.auth.app.model.Provider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data
@Getter
@Setter
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
