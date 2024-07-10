package com.biradar.sidagond.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.biradar.sidagond.beans.Person;
import com.biradar.sidagond.beans.Vehicle;

@Configuration
//@ComponentScan(basePackages = "com.biradar.sidagond.beans")
public class ProjectConfig {

	@Bean
	Vehicle vehicle() {

		Vehicle vehicle = new Vehicle();
		vehicle.setName("Audi-8");
		return vehicle;
	}

	// wiring the vehilce bean in person by method call
//	@Bean
//	Person person() {
//
//		Person person = new Person();
//		person.setName("Sid");
//		person.setVehicle(vehicle());
//		return person;
//	}

	// wiring the vehilce bean in person by passing the vehicle bean as a method
	// parameter
	@Bean
	Person person(Vehicle veh) {

		Person person = new Person();
		person.setName("Sid");
		person.setVehicle(veh);
		return person;
	}

}
