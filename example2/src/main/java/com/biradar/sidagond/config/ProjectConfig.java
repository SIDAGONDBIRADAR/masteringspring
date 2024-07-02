package com.biradar.sidagond.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.biradar.sidagond.beans.Vehicle;

@Configuration
public class ProjectConfig {

	@Bean(name="audiVehicle")
	Vehicle vehicle1() {

		Vehicle vehicle = new Vehicle();
		vehicle.setName("Audi-8");
		return vehicle;
	}
	
	@Bean(value = "hondaVehicle")
	Vehicle vehicle3() {

		Vehicle vehicle = new Vehicle();
		vehicle.setName("Honda");
		return vehicle;
	}
	
	@Primary
	@Bean("tvsVehicle")
	Vehicle vehicle2() {

		Vehicle vehicle = new Vehicle();
		vehicle.setName("TVS");
		return vehicle;
	}



}
