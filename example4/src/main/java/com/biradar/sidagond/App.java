package com.biradar.sidagond;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.biradar.sidagond.beans.Person;
import com.biradar.sidagond.beans.Vehicle;
import com.biradar.sidagond.config.ProjectConfig;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

//		dstem.out.println("Vehicle set by beans in spring :" + veh.getName());

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Person p = context.getBean(Person.class);
		Vehicle veh = context.getBean(Vehicle.class);
		System.out.println("Person name from the spring context :" + p.getName());
		System.out.println("Vehicle name from the spring context :" + veh.getName());
		System.out.println("Vehicle name wired to the Person Object :" + p.getVehicle());
		p.printHello();
		veh.printHello();
		context.close();

	}
}
