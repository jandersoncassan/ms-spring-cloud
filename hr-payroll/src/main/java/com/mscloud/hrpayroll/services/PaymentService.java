package com.mscloud.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.mscloud.hrpayroll.dto.PaymentDTO;
import com.mscloud.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public PaymentDTO getPayment(final Long workerId, final Integer days) {
		Payment payment = Payment.builder()
				.name("Bob")
				.dailyIncoming(200.0)
				.days(days)
				.build();
		return PaymentDTO.converter(payment);
	}
}
