package com.mscloud.hrworker.dto;

import com.mscloud.hrworker.entities.Worker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerDTO {

	private Long id;
	private String name;
	private Double dailyIncome;

	public static WorkerDTO converter(Worker worker) {
		return WorkerDTO.builder()
			.id(worker.getId())
			.name(worker.getName())
			.dailyIncome(worker.getDailyIncome())
			.build();
	}
}
