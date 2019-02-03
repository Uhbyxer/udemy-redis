package com.example.udemyredis.repository.impl;

import com.example.udemyredis.domain.Programmer;
import com.example.udemyredis.repository.ProgrammerRepository;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

	private static final String LIST_KEY = "ProgrammersListKey";
	private static final String SET_KEY = "ProgrammersSetKey";

	private final RedisTemplate<String, Object> redisTemplate;
	private final ListOperations<String, Programmer> listOperations;
	private final SetOperations<String, Programmer> setOperations;

	public ProgrammerRepositoryImpl(RedisTemplate<String, Object> redisTemplate,
			ListOperations<String, Programmer> listOperations, SetOperations<String, Programmer> setOperations) {
		this.redisTemplate = redisTemplate;
		this.listOperations = listOperations;
		this.setOperations = setOperations;
	}

	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		redisTemplate.opsForValue().set(idKey, programmer);
		redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

	@Override
	public void addProgrammerToList(Programmer programmer) {
//		redisTemplate.opsForList().leftPush(LIST_KEY, programmer);
		listOperations.leftPush(LIST_KEY, programmer);
	}

	@Override
	public List<Programmer> getAllProgrammersFromList() {
		return listOperations.range(LIST_KEY, 0 , -1);
	}

	@Override
	public Long getProgrammersListSize() {
		return listOperations.size(LIST_KEY);
	}

	@Override
	public void addProgrammerToSet(Programmer... programmers) {
		setOperations.add(SET_KEY, programmers);
	}

	@Override
	public Set<Programmer> getAllProgrammersFromSet() {
		return setOperations.members(SET_KEY);
	}

	@Override
	public boolean isSetMember(Programmer programmer) {
		return  setOperations.isMember(SET_KEY, programmer);
	}
}
