package com.example.udemyredis.repository;

import com.example.udemyredis.domain.Programmer;

import java.util.List;
import java.util.Set;

public interface ProgrammerRepository {
	// Strings
	void setProgrammerAsString(String idKey, String programmer);

	String getProgrammerAsString(String idKey);

	// List
	void addProgrammerToList(Programmer programmer);

	List<Programmer> getAllProgrammersFromList();

	Long getProgrammersListSize();

	// Set
	void addProgrammerToSet(Programmer... programmers);

	Set<Programmer> getAllProgrammersFromSet();

	boolean isSetMember(Programmer programmer);
}
