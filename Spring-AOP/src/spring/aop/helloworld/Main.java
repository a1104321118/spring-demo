package spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		
		Calculator target = new CalculatorImpl();
		Calculator proxy =  new CalculatorLoggingProxy(target).getLoggingProxy();
		
		System.out.println(target.add(1, 2));
		System.out.println(proxy.add(1, 2));
	}
}
