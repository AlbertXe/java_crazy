package charp18classLoad;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

class Test {
	public void replace(String s1, List<String> s2) {
	}
}

public class MethodParamterTest {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Test.class;
		Method method = clazz.getMethod("replace", String.class, List.class);
		System.out.println("方法个数=" + method.getParameterCount());

		Parameter[] parameters = method.getParameters();
		for (Parameter parameter : parameters) {
			// if (parameter.isNamePresent()) { // 是否包含形参名星系
				System.out.println("参数名：" + parameter.getName());
				System.out.println("参数类型：" + parameter.getType());
				System.out.println("参数泛型：" + parameter.getParameterizedType());
			// }
		}
	}
}
