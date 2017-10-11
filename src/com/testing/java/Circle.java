package com.testing.java;

import org.springframework.context.annotation.Bean;

public class Circle {
	private Integer id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Circle() {}
	
	public Circle(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
