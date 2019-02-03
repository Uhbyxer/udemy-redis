package com.example.udemyredis.controller;

import com.example.udemyredis.domain.Programmer;
import com.example.udemyredis.service.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.springframework.web.client.HttpClientErrorException.NotFound;

@RestController
@RequestMapping("/programmer-string")
public class ProgrammerController {

	private final ProgrammerService programmerService;

	public ProgrammerController(ProgrammerService programmerService) {
		this.programmerService = programmerService;
	}

	@PostMapping
	public Programmer createProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));

		return programmer;
	}

	@GetMapping("/{id}")
	public Programmer getProgrammer(@PathVariable String id) throws IOException, NotFound {
		String programmerAsString = programmerService.getProgrammerAsString(id);
		if (programmerAsString == null) {
			throw new NoSuchElementException("Not found by id: " + id);
		}

		ObjectMapper objectMapper = new ObjectMapper();
		Programmer programmer = objectMapper.readValue(programmerAsString, Programmer.class);
		return programmer;
	}
}