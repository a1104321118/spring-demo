package spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorLoggingProxy {

	//需要被 动态代理 的对象
	private Calculator target;
	
	public CalculatorLoggingProxy(Calculator target) {
		this.target = target;
	}
	
	public Calculator getLoggingProxy() {
		Calculator proxy = null;
		
		//代理对象 由  哪一个  类加载器  加载
		ClassLoader loader = target.getClass().getClassLoader();
		
		//代理对象的类型  ， 即 其中有哪些方法
		Class[] interfaces = new Class[]{Calculator.class};
		
		//当调用代理对象其中的方法时，该执行的代码
		InvocationHandler invoke = new InvocationHandler() {
			/**
			 * proxy:正在返回的代理对象，一般情况下，在invoke方法中都不使用该对象
			 * method:正在被调用的方法
			 * args:调用方法时，传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//日志
				System.out.println("method--" + method.getName() + "--begins with" + Arrays.asList(args));
				//执行方法
				Object result = method.invoke(target, args);
				//日志
				System.out.println("method--" + method.getName() + "--ends with" + result);
				return result;
			}
		};
		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, invoke);
		
		return proxy;
	}

}
