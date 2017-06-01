package spring.bean.autowire;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Main {
	
	@Autowired
	public Person person;
	
	public void test() {
		System.out.println(this.person.getName());
	}
	
	public static void main(String[] args) {
		
		//测试autowire 属性，要求：bean的id 要和 javaBean的 属性名相同
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-autowire.xml");
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
		Main main = new Main();
		main.test();
	}
	
}
