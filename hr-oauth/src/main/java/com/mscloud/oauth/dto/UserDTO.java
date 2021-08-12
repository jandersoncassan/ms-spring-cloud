package com.mscloud.oauth.dto;

import java.util.Set;

import com.mscloud.oauth.entities.Role;

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

}
