package spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

//实例工厂方法：先实例出对象，再调用方法
public class InstanceCarFactory {
	
	private Map<String, Car> cars = null;
	
	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("Audi", new Car("Audi", 300000, 10));
		cars.put("Ford", new Car("Ford", 400000, 10));
	}

	public Car getCar(String name) {
		return cars.get(name);
	}
}
