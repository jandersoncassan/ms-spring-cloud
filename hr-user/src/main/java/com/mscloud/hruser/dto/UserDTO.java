package com.mscloud.hruser.dto;

import java.util.Set;

import com.mscloud.hruser.entities.Role;
import com.mscloud.hruser.entities.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

	private Long id;
	private String email;
	private String name;
	private String password;
	private Set<Role> roles;

	public static UserDTO converter(User user) {
		return UserDTO.builder()
				.id(user.getId())
				.name(user.getName())
				.password(user.getPassword())
				.email(user.getEmail())
				.roles(user.getRoles())
				.build();
	}

}
