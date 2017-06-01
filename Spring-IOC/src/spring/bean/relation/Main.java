package spring.bean.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.autowire.Address;
import spring.bean.autowire.Person;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-relation.xml");
		
		Address address2 = (Address) ctx.getBean("address2");
		
		System.out.println(address2);
		
		Person person1 = (Person) ctx.getBean("person1");
		System.out.println(person1);
	}
}
