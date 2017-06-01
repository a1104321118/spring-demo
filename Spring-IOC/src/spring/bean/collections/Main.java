package spring.bean.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//测试p命名空间
		Person person4 = (Person)ctx.getBean("person4");
		System.out.println(person4);
		
		
		//演示独立集合 bean 片段
		Person person3 = (Person)ctx.getBean("person3");
		System.out.println(person3);
		
		//演示 当类中有 list 或者 map 的时候，bean 的配置
		Person person2 = (Person)ctx.getBean("person2");
		System.out.println(person2);
		
		//演示properties的test
		DataSource dataSource = (DataSource) ctx.getBean("datasource");
		System.out.println(dataSource);
	}
}
