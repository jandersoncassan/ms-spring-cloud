package com.mscloud.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscloud.hrpayroll.dto.PaymentDTO;
import com.mscloud.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService service;
	
	@GetMapping("/{workerId}/days/{days}")
	private ResponseEntity<PaymentDTO> getPayment(@PathVariable final Long workerId, 
												  @PathVariable final Integer days) {
		PaymentDTO payment = service.getPayment(workerId, days);		
		return ResponseEntity.ok(payment);
	}
}
