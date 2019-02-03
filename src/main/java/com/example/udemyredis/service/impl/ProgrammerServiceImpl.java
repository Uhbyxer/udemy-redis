package com.example.udemyredis.service.impl;

import com.example.udemyredis.repository.ProgrammerRepository;
import com.example.udemyredis.service.ProgrammerService;
import org.springframework.stereotype.Service;

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
}
