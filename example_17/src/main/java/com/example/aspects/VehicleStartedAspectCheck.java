package com.example.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class VehicleStartedAspectCheck {
	
	private Logger logger = Logger.getLogger(VehicleStartedAspectCheck.class.getName());
	
	@Before("execution(* com.example.services.*.*(..)) && args(vehicleStarted,..)")
	public void vehicleStarted(JoinPoint joinPoint,boolean vehicleStarted) {
		if(!vehicleStarted) {
			throw new RuntimeException("Vehicle not started");
		}
	}

}
