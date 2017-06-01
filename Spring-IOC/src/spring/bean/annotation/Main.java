package spring.bean.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.bean.annotation.controller.UserController;
import spring.bean.annotation.repository.UserRepository;
import spring.bean.annotation.service.UserService;

public class Main {
	
	public static void main(String[] args) {
		
		/**
		 * 通过注解的方式，实现不配置xml中的bean，就可以获取 bean 的实例
		 * 要求:getBean  的  id 是  类名 的首字母小写，或者使用getBean(类名.class)
		 * 例如:UserController uc = (UserController) ctx.getBean("userController");
		 *     ^^^^^^^^^^^^^^                                   ^^^^^^^^^^^^^^^
		 * 注意：在xml文件里面仍然需要配置自动扫描的包
		 * <context:component-scan base-package="spring.bean.annotation" > 
		 * 
		 * 使用 @autowired 注解来实现自动装配
		 */
		
		//自动扫描要求  bean  的  id 是 类名的首字母小写
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");
		TestObject to1 = (TestObject) ctx.getBean("testObject");
		TestObject to2 = (TestObject) ctx.getBean(TestObject.class);
		System.out.println(to1);
		System.out.println(to2);
		
		UserController uc = (UserController) ctx.getBean("userController");
		uc.excute();
		System.out.println(uc);
		
		UserRepository ur = (UserRepository) ctx.getBean("userRepository");
		System.out.println(ur);
		
		UserService us = (UserService) ctx.getBean("userService");
		System.out.println(us);
	}
}
