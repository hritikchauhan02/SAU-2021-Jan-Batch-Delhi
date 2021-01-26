package com.au.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");
		
	}
	
	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("Second Advice");
		
	}
	
	//Define pointcut expression
	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
	}

	@After("execution(public * get*())")
	public void afterAdvice() {
		System.out.println("@After advice Execution");
	}

	@AfterReturning("execution(public * set*())")
	public void afterReturningAdvice() {
		System.out.println("@AfterReturning advice execution");
	}

	@AfterThrowing("execution(public * throwException())")
	public void afterThrowingAdvice() {
		System.out.println("@AfterThrowing advice execution");
	}

	@Around("execution(public * getName())")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Inside Around advice Before invoking getName() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Inside Around advice After invoking getName() method. Return value is = "+value);
		return value;
	}

}
