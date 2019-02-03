package com.example.udemyredis.repository.impl;

import com.example.udemyredis.repository.ProgrammerRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

	private final RedisTemplate<String, Object> redisTemplate;

	public ProgrammerRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
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
}
