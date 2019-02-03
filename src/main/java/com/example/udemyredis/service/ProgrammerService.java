package com.example.udemyredis.service;

import com.example.udemyredis.domain.Programmer;

import java.util.List;

public interface ProgrammerService {
	void setProgrammerAsString(String idKey, String programmer);

	String getProgrammerAsString(String idKey);

	// List
	void addProgrammerToList(Programmer programmer);

	List<Programmer> getAllProgrammersFromList();

	Long getProgrammersListSize();
}
