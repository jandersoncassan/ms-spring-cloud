package com.mscloud.hrworker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mscloud.hrworker.dto.WorkerDTO;
import com.mscloud.hrworker.entities.Worker;
import com.mscloud.hrworker.repository.WorkerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkerService {

	private final WorkerRepository repository;
	
	public List<WorkerDTO> findAll(){
		return repository.findAll().stream().map(WorkerDTO::converter).collect(Collectors.toList());
	}
	
	public WorkerDTO findById(final Long id) {
		Worker worker = repository.findById(id).get();
		return WorkerDTO.converter(worker);
	}
}
