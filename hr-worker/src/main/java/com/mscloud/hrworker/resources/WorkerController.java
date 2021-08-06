package com.mscloud.hrworker.resources;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscloud.hrworker.dto.WorkerDTO;
import com.mscloud.hrworker.service.WorkerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerController {
	
	private final Environment env;	
	private final WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll(){
		List<WorkerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
		
		/*
		 * log.info("PORT: {}", env.getProperty("local.server.port"));
		 * 
		 * try { Thread.sleep(23000l); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		WorkerDTO obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
}
