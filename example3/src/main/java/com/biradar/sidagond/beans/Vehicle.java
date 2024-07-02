package com.biradar.sidagond.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Vehicle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@PostConstruct
	public void initialize() {
		this.name="MT15";
	}
	
	@PreDestroy
	public void beanDestroy() {
		System.out.println("Destroy bean before destroying the context and beans");
	}
	
	
	public void printHello() {
		System.out.println("Printing hello from vehicle method");
	}

}
