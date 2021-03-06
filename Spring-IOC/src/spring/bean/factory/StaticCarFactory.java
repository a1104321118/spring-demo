package spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

//静态工厂方法：直接调用某一个类的静态方法，就可以返回Bean的实例
public class StaticCarFactory {
	
	private static Map<String, Car> cars = new HashMap<String, Car>();
	
	static{
		cars.put("Audi", new Car("Audi", 300000, 10));
		cars.put("Ford", new Car("Ford", 400000, 10));
		
	}
	
	public static Car getCar(String name) {
		
		return cars.get(name);
	}

}
