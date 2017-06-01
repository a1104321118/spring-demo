package spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidationAspect {

	/**
	 * 引用外部的 切入点声明。如果在不同的包下，还要加上包名
	 * @param joinPoint
	 */
	@Before("LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("validate:" + Arrays.asList(joinPoint.getArgs()));
		
	}
}
