package charp14annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target(value = { ElementType.METHOD })  // 修饰什么
@Retention(value = RetentionPolicy.RUNTIME) // 保留到什么时候
public @interface MyTag { // 根据有没有成员变量   无- 就是标记annotion   有-元数据
	// 定义两个成员变量
	String name() default "xiehongwei";
	int age();
	
}
