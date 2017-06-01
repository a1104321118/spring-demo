package spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		
		//创建 Spring 的 IoC 对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//从IoC容器中获得 Bean 实例
		HelloWorld hello =(HelloWorld)ctx.getBean("helloworld");		
		//调用hello方法
		hello.hello();
		
		Car car = (Car)ctx.getBean("car");
		System.out.println(car);
		
		Person person = (Person)ctx.getBean("person");
		System.out.println(person);
	}
}
