package com.biradar.sidagond;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.biradar.sidagond.beans.Vehicle;
import com.biradar.sidagond.config.ProjectConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	Vehicle vehicle = new Vehicle();
		vehicle.setName("Hero Honda");
		System.out.println("Vehicle set by new keyword not by spring beans :" + vehicle.getName());

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Vehicle veh = context.getBean(Vehicle.class);
		System.out.println("Vehicle set by beans in spring :" + veh.getName());
	}
}
