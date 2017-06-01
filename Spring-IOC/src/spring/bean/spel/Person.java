package spring.bean.spel;

public class Person {
	private String name;
	
	//引用Address 的 city属性
	private String city;
	
	//if car.price > 300000  金领
	//else 白领
	private String info;
	private Car car;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + ", info=" + info + ", car=" + car + "]";
	}
	
}
