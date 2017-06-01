package spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	/**
	 * 这里的 before 和 after 是针对
	 * bean-lifeCycle 里面的 init-method 的顺序
	 */

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization:" + "beanName:" + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization:" + "beanName:" + beanName);
		//在初始化之前就把 车名改成 Audi，则最后出现的Audi，比bean 里面的配置要迟
		Car car = new Car();
		car.setBrand("Audi");
		return car;
	}

}
