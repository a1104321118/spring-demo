package spring.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;

//通过自定义的 FactoryBean 需要实现 接口 FactoryBean<T>
public class CarFactoryBean implements FactoryBean<Car> {
	
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public Car getObject() throws Exception {
		return new Car("BMW",500000,10);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
