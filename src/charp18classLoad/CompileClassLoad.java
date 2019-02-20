package charp18classLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载起
 * 
 * @ClassName: CompileClassLoad
 * @Description:
 * @author: 谢洪伟
 * @date: 2019年1月15日 上午9:39:34
 */
public class CompileClassLoad extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class rtn = null;
		String file = name.replace(".", "/");
		String javaFileName = file+".java";
		String classFileName = file + ".class";
		File javaFile  =  new File(javaFileName);
		File classFile  =  new File(classFileName);
		// java 存在 class 不存在  或 java修改时间晚于class时间
		if (javaFile.exists()&&!classFile.exists() || javaFile.lastModified()>classFile.lastModified()){
			if (!compile(javaFile) || !classFile.exists()) {
				System.out.println("class not found");
			}
		}
		if (classFile.exists()) {
			byte[] bs = getBytes(classFile);
			// 父类 将二进制数据 转成class 对象
			rtn = defineClass(name, bs, 0, bs.length);
		}
		if (rtn == null)
			System.out.println("class not found");
		return rtn;
	}

	private byte[] getBytes(File classFile) {
		FileInputStream fis = null;
		byte[] bs = null;
		try {
			fis = new FileInputStream(classFile);
			int len = (int) classFile.length();
			bs = new byte[len];
			int read = fis.read(bs);
			if (read < len)
				System.out.println("不能一次读完");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bs;
	}

	private boolean compile(File javaFile) {
		try {
			Process p = Runtime.getRuntime().exec("javac " + javaFile);
			p.waitFor(); // 阻塞其他线程
			int value = p.exitValue(); // 结束返回值
			return value == 0;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (args.length < 1) {
			System.out.println("缺少目标类");
			System.out.println("格式：java CompileClassLoad ClassName");
		}
		// 第一参数是要运行的类 ，其他都是参数
		String clazz = args[0];
		String[] pros = new String[args.length - 1];
		System.arraycopy(args, 1, pros, 0, pros.length);
		CompileClassLoad compileClassLoad = new CompileClassLoad();
		Class<?> loadClass = compileClassLoad.loadClass(clazz);

		Method method = loadClass.getMethod("main", new String[0].getClass());
		Object[] arrayargs = { pros };
		method.invoke(null, arrayargs);
	}
}
