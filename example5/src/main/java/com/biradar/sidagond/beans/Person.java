package com.biradar.sidagond.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name="Sid";
	
//	@Autowired
	private  Vehicle vehicle;
	
	@Autowired
	public Person(Vehicle veh) {
		System.out.println("Person bean constructor called by spring");
		this.vehicle=veh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

//	@Autowired
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void printHello() {
		System.out.println("Printing hello from Person class");
	}

	@Override
	public String toString() {
		return "Person name is : " + name;
	}

}
