package com.mscloud.hruser.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mscloud.hruser.dto.UserDTO;
import com.mscloud.hruser.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserService userService;
			
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		log.info("GET findAll");
		List<UserDTO> list = userService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable("id") final Long id){
		log.info("GET findById : {}", id);
		UserDTO user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam("email") final String email){
		log.info("GET findByEmail : {}", email);
		UserDTO user = userService.findByEmail(email);
		return ResponseEntity.ok(user);
	}

}
