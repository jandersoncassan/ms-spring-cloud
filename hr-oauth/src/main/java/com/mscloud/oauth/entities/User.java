package com.mscloud.oauth.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String name;
	private String password;
	@Builder.Default
	private Set<Role> roles = new HashSet<>();
	
}
