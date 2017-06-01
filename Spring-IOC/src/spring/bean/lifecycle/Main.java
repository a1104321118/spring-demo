package spring.bean.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-lifeCycle.xml");
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		//关闭IoC容器
		ctx.close();
	}
}
