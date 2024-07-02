package com.biradar.sidagond.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.biradar.sidagond.beans.Vehicle;

@Configuration
public class ProjectConfig {

	@Bean
	Vehicle vehicle() {

		Vehicle vehicle = new Vehicle();
		vehicle.setName("Audi-8");
		return vehicle;
	}
	
	

	@Bean
	String hello() {
		return "helloooooo";
	}

	@Bean
	Integer number() {
		return 16;
	}

}
