package com.biradar.sidagond.aspects;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspects {

	private Logger logger = Logger.getLogger(LoggerAspects.class.getName());

	@Around("execution(* com.biradar)")
	public void log(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info(joinPoint.getSignature().toString() + " method execution starts");
		Instant start = Instant.now();
		joinPoint.proceed();
		Instant end = Instant.now();
		long timeTook = Duration.between(start, end).toMillis();
		logger.info("Time took to execute the method is :" + timeTook);
		logger.info(joinPoint.getSignature().toString() + " method execution ends");
	}

}
