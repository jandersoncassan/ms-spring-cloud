package com.mscloud.oauth.resources;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscloud.oauth.entities.User;
import com.mscloud.oauth.services.OauthUserService;

@RestController
@RequestMapping("/oauth-users")
public class OauthUserController {
	
	@Autowired
	private OauthUserService userService;
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@PathParam("email") final String email){
		 User user = userService.findByEmail(email);
		 return ResponseEntity.ok(user);
	}

}
