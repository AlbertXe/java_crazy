package charp14annotion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
	@Testable
	public void demo1() {
		System.out.println("demo1");
	}
	@Testable
	public void demo2() {
		throw new RuntimeException("demo2失败");
	}
	@Testable
	public void demo3() {
		System.out.println("demo3");
	}

	public void demo4() {
		
	}
	public static void main(String[] args) {
		int past = 0;
		int fail = 0;
		try {
			Method[] methods = Class.forName("charp14annotion.MyTest").getMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(Testable.class)) {//如果该方法 使用了Testable修饰
					try {
						method.invoke(Class.forName("charp14annotion.MyTest").newInstance());//调用的对象
						past+=1;
					} catch (Exception e) {
						System.out.println("运行失败");
						fail+=1;
					}
				}
			}
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("past= "+past+" fail= "+fail);
	}
}
