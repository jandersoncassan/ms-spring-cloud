package com.mscloud.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;

	private String name;
	private Double dailyIncoming;
	private Integer days;
	
	public double getTotal() {
		return dailyIncoming * days;
	}
	
}
