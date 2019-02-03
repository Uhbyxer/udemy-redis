package com.example.udemyredis.service.impl;

import com.example.udemyredis.domain.Programmer;
import com.example.udemyredis.repository.ProgrammerRepository;
import com.example.udemyredis.service.ProgrammerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
 public class ProgrammerServiceImpl implements ProgrammerService {

	private final ProgrammerRepository repository;

	public ProgrammerServiceImpl(ProgrammerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		repository.setProgrammerAsString(idKey, programmer);
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return repository.getProgrammerAsString(idKey);
	}

	@Override
	public void addProgrammerToList(Programmer programmer) {
		repository.addProgrammerToList(programmer);
	}

	@Override
	public List<Programmer> getAllProgrammersFromList() {
		return repository.getAllProgrammersFromList();
	}

	@Override
	public Long getProgrammersListSize() {
		return repository.getProgrammersListSize();
	}
}
