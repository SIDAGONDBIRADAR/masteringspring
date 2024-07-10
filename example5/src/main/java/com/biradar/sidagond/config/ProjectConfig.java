package com.biradar.sidagond.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.biradar.sidagond.beans")
public class ProjectConfig {

//	@Bean
//	Vehicle vehicle() {
//
//		Vehicle vehicle = new Vehicle();
//		vehicle.setName("Audi-8");
//		return vehicle;
//	}

	// wiring the vehilce bean in person by method call
//	@Bean
//	Person person() {
//
//		Person person = new Person();
//		person.setName("Sid");
//		person.setVehicle(vehicle());
//		return person;
//	}

//	// wiring the vehilce bean in person by passing the vehicle bean as a method
//	// parameter
//	@Bean
//	Person person(Vehicle veh) {
//
//		Person person = new Person();
//		person.setName("Sid");
//		person.setVehicle(veh);
//		return person;
//	}

	// autowiring the vehilce bean in person by marking class field with autowire
	// annotation or else no code in projectconfig file and mark bean class with @Componnt
//	@Bean
//	Person person(Vehicle veh) {
//
//		Person person = new Person();
//		person.setName("Sid");
//		person.setVehicle(veh);
//		return person;
//	}

}
