package charp18classLoad.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 读取文件 生成对象
 * 
 * @ClassName: ObjectPoolFactory
 * @Description:
 * @author: 谢洪伟
 * @date: 2019年1月15日 下午1:47:03
 */
public class ObjectPoolFactory {
	private Map<String, Object> pool = new HashMap();
	private Properties properties = new Properties();

	public void init(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(new File(fileName));
			properties.load(fis);

			initPool();
			initProperties();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 传入类名创建对象
	 * 
	 * @param name
	 * @return
	 */
	private Object createObject(String name) {
		try {
			Class<?> clazz = Class.forName(name);
			return clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据配置文件来初始化对象池
	 */
	private void initPool() {
		Set<String> names = properties.stringPropertyNames();
		for (String name : names) {
			if (!name.contains("%")) { // 没有%表示 类 有%表示前面类，后面属性
				String value = properties.getProperty(name);
				pool.put(name, createObject(value));
			}
		}
	}

	/**
	 * 根据配置文件初始化属性 (set 也可以field 设置)
	 */
	private void initProperties() {
		Set<String> names = properties.stringPropertyNames();
		for (String name : names) {
			if (name.contains("%")) {
				String[] nameAndPro = name.split("%");
				// 对象方法反射
				Object target = getObject(nameAndPro[0]);
				String mtdName = "set" + nameAndPro[1].substring(0, 1).toUpperCase() + nameAndPro[1].substring(1);
				Class<? extends Object> class1 = target.getClass();
				try {
					Method method = class1.getMethod(mtdName, String.class);
					method.invoke(target, properties.getProperty(name));
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Object getObject(String name) {
		return pool.get(name);
	}

	public static void main(String[] args) {
		ObjectPoolFactory factory = new ObjectPoolFactory();
		factory.init("src/charp18classLoad/reflect/obj.txt");
		User user = (User) factory.getObject("a");
		System.out.println(user.getName());
	}
}
