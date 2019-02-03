package com.example.udemyredis.controller;

import com.example.udemyredis.domain.Programmer;
import com.example.udemyredis.service.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.springframework.web.client.HttpClientErrorException.NotFound;

@RestController
public class ProgrammerController {

	private final ProgrammerService programmerService;

	public ProgrammerController(ProgrammerService programmerService) {
		this.programmerService = programmerService;
	}

	@PostMapping("/programmer-string")
	public Programmer createProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));

		return programmer;
	}

	@GetMapping("/programmer-string/{id}")
	public Programmer getProgrammer(@PathVariable String id) throws IOException, NotFound {
		String programmerAsString = programmerService.getProgrammerAsString(id);
		if (programmerAsString == null) {
			throw new NoSuchElementException("Not found by id: " + id);
		}

		ObjectMapper objectMapper = new ObjectMapper();
		Programmer programmer = objectMapper.readValue(programmerAsString, Programmer.class);
		return programmer;
	}

	@PostMapping("/programmer-list")
	public Programmer addProgrammerToList(@RequestBody Programmer programmer) {
		programmerService.addProgrammerToList(programmer);
		return programmer;
	}

	@GetMapping("/programmer-list")
	public List<Programmer> getProgrammerList() {
		return programmerService.getAllProgrammersFromList();
	}


	@GetMapping("/programmer-list/count")
	public Long getProgrammerListSize() {
		return programmerService.getProgrammersListSize();
	}

	@PostMapping("/programmer-set")
	public Programmer[] addProgrammerToSet(@RequestBody Programmer ... programmers) {
		programmerService.addProgrammerToSet(programmers);
		return programmers;
	}

	@GetMapping("/programmer-set")
	public Set<Programmer> getProgrammerSet() {
		return programmerService.getAllProgrammersFromSet();
	}

	@GetMapping("/programmer-set/is-member")
	public boolean isSetMember(@RequestBody Programmer programmer) {
		return programmerService.isSetMember(programmer);
	}

	@PostMapping("/programmer-hash")
	public Programmer addProgrammerToHash(@RequestBody Programmer programmer) {
		programmerService.saveHash(programmer);
		return programmer;
	}

	@PutMapping("/programmer-hash")
	public Programmer updateProgrammerToHash(@RequestBody Programmer programmer) {
		programmerService.updateHash(programmer);
		return programmer;
	}

	@GetMapping("/programmer-hash")
	public Map<Integer, Programmer> getAllProgrammersFromHash() {
		Map<Integer, Programmer> allHash = programmerService.findAllHash();
		return allHash;
	}

	@GetMapping("/programmer-hash/{id}")
	public Programmer getProgrammerFromHash(@PathVariable int id) {
		return programmerService.findInHash(id);
	}

	@DeleteMapping("/programmer-hash/{id}")
	public void deleteProgrammerFromHash(@PathVariable int id) {
		programmerService.deleteHash(id);
	}

}
