package com.mscloud.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscloud.hrpayroll.dto.PaymentDTO;
import com.mscloud.hrpayroll.entities.Payment;
import com.mscloud.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentService service;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<PaymentDTO> getPayment(@PathVariable final Long workerId, @PathVariable final Integer days) {
		// PaymentDTO payment = service.getPayment(workerId, days); //RESTTEMPLATE
		PaymentDTO payment = service.getPaymentFeign(workerId, days);// FEIGNCLIENT
		return ResponseEntity.ok(payment);
	}

	public ResponseEntity<PaymentDTO> getPaymentAlternative(final Long workerId, final Integer days) {
		Payment payment = Payment.builder().name("Brann").dailyIncoming(300.0).days(days).build();		
		return ResponseEntity.ok(PaymentDTO.converter(payment));
	}
}
