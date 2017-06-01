package spring.bean.properties;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.autowire.Car;

public class Main {

public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-properties.xml");
		DataSource dataSource = (DataSource) ctx.getBean("datasource");
		System.out.println(dataSource);
	}
}
