package com.mscloud.oauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mscloud.oauth.dto.UserDTO;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignCient {

	@GetMapping("/search")
	ResponseEntity<UserDTO> findByEmail(@RequestParam("email") final String email);

}
