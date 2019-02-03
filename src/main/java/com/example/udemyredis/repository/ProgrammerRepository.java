package com.example.udemyredis.repository;

public interface ProgrammerRepository {
	void setProgrammerAsString(String idKey, String programmer);

	String getProgrammerAsString(String idKey);
}
