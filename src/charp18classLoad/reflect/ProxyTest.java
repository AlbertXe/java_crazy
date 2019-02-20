package charp18classLoad.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		MyInvocationHandler handler = new MyInvocationHandler();
		Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[] { Person.class }, handler);
		person.walk();
		person.sayHello("孙悟空");
	}
}

interface Person {
	void walk();

	void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (args == null) {
			System.out.println("args=" + 0);
		} else {
			System.out.println("args=" + args.length);
		}
		return null;
	}

}
