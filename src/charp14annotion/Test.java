package charp14annotion;

import java.lang.annotation.Annotation;

public class Test {
	@MyTag(age = 27)
	public void info(){
	}
	
	public static void main(String[] args) {
		// 提取 注解信息
		try {  // 包名.类名
			Annotation[] annotations = Class.forName("charp14annotion.Test").getMethod("info").getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
				if (annotation instanceof MyTag) {//取出数据
					System.out.println(((MyTag)annotation).age());
					System.out.println(((MyTag)annotation).name());
				}
			}
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
