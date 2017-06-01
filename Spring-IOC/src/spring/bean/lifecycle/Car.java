package spring.bean.lifecycle;

public class Car {
	private String brand;

	public Car() {
		System.out.println("Car no-params Construct...");
	}

	public void setBrand(String brand) {
		System.out.println("set Brand..");
		this.brand = brand;
	}

	public void init() {
		System.out.println("Car Init...");
	}

	public void destory() {
		System.out.println("Car Destory..");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
	

}
