package com.example.udemyredis.service.impl;

import com.example.udemyredis.domain.Programmer;
import com.example.udemyredis.repository.ProgrammerRepository;
import com.example.udemyredis.service.ProgrammerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

	@Override
	public void addProgrammerToSet(Programmer... programmers) {
		repository.addProgrammerToSet(programmers);
	}

	@Override
	public Set<Programmer> getAllProgrammersFromSet() {
		return repository.getAllProgrammersFromSet();
	}

	@Override
	public boolean isSetMember(Programmer programmer) {
		return repository.isSetMember(programmer);
	}

	@Override
	public void saveHash(Programmer programmer) {
		repository.saveHash(programmer);
	}

	@Override
	public void updateHash(Programmer programmer) {
		repository.updateHash(programmer);
	}

	@Override
	public Map<Integer, Programmer> findAllHash() {
		return repository.findAllHash();
	}

	@Override
	public Programmer findInHash(int id) {
		return repository.findInHash(id);
	}

	@Override
	public void deleteHash(int id) {
		repository.deleteHash(id);
	}
}
