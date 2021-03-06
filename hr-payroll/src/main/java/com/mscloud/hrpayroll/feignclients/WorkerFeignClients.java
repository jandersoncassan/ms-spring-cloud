package com.mscloud.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mscloud.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClients {

	@GetMapping("/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}


//@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
//deixo fixo a url se for estático , apenas 1 instância, mas vamosmutilizar o ribbon e deixar dinâmico