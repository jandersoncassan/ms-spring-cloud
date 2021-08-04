package com.mscloud.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mscloud.hrpayroll.dto.PaymentDTO;
import com.mscloud.hrpayroll.entities.Payment;
import com.mscloud.hrpayroll.entities.Worker;
import com.mscloud.hrpayroll.feignclients.WorkerFeignClients;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClients workerFeignClient;
	
	@Value("${hr-worker.host}")
	private String workerHost;

	public PaymentDTO getPayment(final Long workerId, final Integer days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
		
		Worker worker = restTemplate.getForObject(workerHost, Worker.class, uriVariables);
		
		Payment payment = Payment.builder()
				.name(worker.getName())
				.dailyIncoming(worker.getDailyIncome())
				.days(days)
				.build();
		
		return PaymentDTO.converter(payment);
	}
		
	
	public PaymentDTO getPaymentFeign(final Long workerId, final Integer days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		Payment payment = Payment.builder()
				.name(worker.getName())
				.dailyIncoming(worker.getDailyIncome())
				.days(days)
				.build();
		
		return PaymentDTO.converter(payment);
	}
	
}
