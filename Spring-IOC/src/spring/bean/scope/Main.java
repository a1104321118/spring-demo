package spring.bean.scope;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.autowire.Car;

public class Main {

public static void main(String[] args) {
		
	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scope.xml");
	
	Car car1 = (Car) ctx.getBean("car1");
	Car car2= (Car) ctx.getBean("car1");
	System.out.println(car1 == car2);
	}
}
