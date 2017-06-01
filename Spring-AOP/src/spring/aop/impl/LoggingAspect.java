package spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 该类是日志切面层
 * 把这个类声明为一个切面：
 * 1.需要把该类放到IOC容器中，使用 @component 注解
 * 2.使用 @Aspect 注解 
 * 
 * 可以使用 @Order 指定切面优先级，越小越优先
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	
	/**
	 * 声明切入点的表达式方法，一般不需要往里面写代码
	 * 符号 * 表示通配符   原来为：public int spring.aop.impl.Calculator.add(int, int)
	 */
	@Pointcut("execution(* spring.aop.impl.*.*(..))")
	public void declareJoinPointExpression(){}
	
	/**
	 * 声明该方法是一个  前置  通知：在目标方法开始之前执行
	 * @param joinPoint 链接细节，可以获得方法名和方法参数
	 */
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("Method begin: methodName=" + methodName +",Args="+args);
	}
	
	/**
	 * 后置通知：在方法结束后，无论方法是否发生异常，都会执行
	 * @param joinPoint
	 */
	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Method end: methodName=" + methodName);
	}
	
	/**
	 * 返回通知，在方法正常执行之后再执行的方法
	 * 可以访问到方法的  返回值
	 * 如果方法出现异常，则不会执行
	 * @param joinPoint
	 */
	@AfterReturning(value="declareJoinPointExpression()",returning="result")
	public void returnMethod(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Method ends with " + result);
	}
	
	/**
	 * 异常通知：在方法执行出现异常的时候执行
	 * @param joinPoint 
	 * @param e	出现的异常，只会执行类型匹配的异常
	 * 例如：如果把 Exception 变为  java.lang.ArithmeticException，
	 * 那么在出现 NullPointerException 异常的时候，该方法并不会执行
	 */
	@AfterThrowing(value="declareJoinPointExpression())",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Method "+ methodName +"occurs exception " + e);
	}
	
	/**
	 * 四类通知的过程 == 环绕通知 
	 * 环绕通知：@Around  必须有返回值 入参为：ProceedingJoinPoint ，类似于 JoinPoint
	 * 但是执行的顺序是:
	 * 
	 * 前置-->后置-->返回/异常
	 * 
	 * 
	 * 四类通知类似于以下的过程
	 * try {
	 * 
	 * 		//前置通知(在指定方法执行前就会执行)
	 * 		Method ....
	 * 		//返回通知(在指定方法正常执行之后执行，否则不执行)
	 * 
	 * } catch(Exception e) {
	 * 
	 * 		//异常通知(在方法出现异常之后执行，否则不执行)
	 * 
	 * } finally {
	 * 
	 * 		//后置通知(无论方法正常执行还是出现异常，都会执行)
	 * 
	 * }
	 */
}
