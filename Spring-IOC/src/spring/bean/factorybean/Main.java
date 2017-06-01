package spring.bean.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-factoryBean.xml");
		
		Car car1 = (Car) ctx.getBean("car");
		System.out.println(car1);
		
	}
	
}
