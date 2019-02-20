package charp18classLoad;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoadProp {
	public static void main(String[] args) throws IOException {
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统加载器" + systemClassLoader);
		Enumeration<URL> resources = systemClassLoader.getResources("");// classpath
		while (resources.hasMoreElements()) {
			System.out.println(resources.nextElement());
		}

		ClassLoader parent = systemClassLoader.getParent();
		System.out.println("扩展类加载器" + parent);
		System.out.println("扩展类加载器加载路径" + System.getProperty("java.ext.dirs"));

		System.out.println("root 加载器" + parent.getParent());
	}
}
