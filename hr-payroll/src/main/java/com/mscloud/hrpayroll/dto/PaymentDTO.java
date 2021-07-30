package com.mscloud.hrpayroll.dto;

import com.mscloud.hrpayroll.entities.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {

	private String name;
	private Double dailyIncoming;
	private Integer days;
	private Double total;

	public static PaymentDTO converter(Payment payment) {
		return PaymentDTO.builder()
				.name(payment.getName())
				.dailyIncoming(payment.getDailyIncoming())
				.days(payment.getDays())
				.total(payment.getTotal())
				.build();
	}

}
