package com.example.udemyredis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Programmer implements Serializable {
	private String id;

	private String company;

	private String name;
}
