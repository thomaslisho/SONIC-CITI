package com.punisher;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Configuration
public class StudentAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.punisher.*.*(..))")
	public void beforeLog(JoinPoint jp) {
        logger.info("BEFORE");
		logger.info("Allowed execution for {}", jp);
	}
	
	@BeforeThrowing(pointcut = "execution(* com.punisher.*.*(..))", throwing = "ex")
    public void logError(Exception ex) {
        System.out.println("Exception CAUGHT at AOP");
		ex.printStackTrace();
    }
	
	@After("execution(* com.punisher.*.*(..))")
	public void afterLog(JoinPoint jp) {
		logger.info("AFTER");
		logger.info("Allowed execution for {}", jp);
	}
	
}
