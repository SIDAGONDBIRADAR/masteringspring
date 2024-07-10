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
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Person person = context.getBean(Person.class);
		System.out.println("Person name from Spring Context is: " + person.getName());
		System.out.println("Vehicle that Person own is: " + person.getVehicle());
	}
}
