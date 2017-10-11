package com.testing.java;

import javax.persistence.Entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.persistence.Id;

@Scope("prototype")
@Entity
public class Circle {
	@Id
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
	
	public static Circle createInstance(Integer id, String name) {
		return (new Circle(id, name));
	}
	
	
}
