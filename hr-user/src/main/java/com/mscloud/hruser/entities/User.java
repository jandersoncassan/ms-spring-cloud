package com.mscloud.hruser.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mscloud.hruser.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String name;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="tb_user_role", 
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	@Builder.Default
	private Set<Role> roles = new HashSet<>();
	
	public static User converter(UserDTO userDTO) {
		return User.builder()
				.email(userDTO.getEmail())
				.name(userDTO.getName())
				.password(userDTO.getPassword())
				.build();
	}
	
}
