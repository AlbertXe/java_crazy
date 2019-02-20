package charp18classLoad.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 获取泛型的相关信息
 * 
 * @ClassName: GenericTest
 * @Description:
 * @author: 谢洪伟
 * @date: 2019年1月15日 下午3:21:36
 */
public class GenericTest {
	private Map<String, Object> scope;

	public static void main(String[] args) throws Exception, SecurityException {
		Class clazz = GenericTest.class;
		Field field = clazz.getDeclaredField("scope");
		System.out.println("scope类型=" + field.getType());

		// 泛型
		Type gType = field.getGenericType();
		if (gType instanceof ParameterizedType) {
			Type rawType = ((ParameterizedType) gType).getRawType();
			System.out.println("原始类型=" + rawType);

			Type[] arguments = ((ParameterizedType) gType).getActualTypeArguments();
			for (Type type : arguments) {
				System.out.println("泛型=" + type);
			}
		}

	}
}
