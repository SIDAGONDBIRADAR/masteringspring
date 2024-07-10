package com.biradar.sidagond.beans;

public class Person {

	private String name;
	
	private Vehicle vehicle;
	
	public Person() {
		System.out.println("Person bean constructor called by spring");
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
