package charp5.lambda;

import javax.swing.JFrame;

/**
 * 
 * @ClassName:  ConverterTest   
 * @Description:lambda  引用类方法
 * @author: 谢洪伟 
 * @date:   2018年9月26日 下午2:29:17
 */
public class ConverterTest {
	public static void main(String[] args) {
		Converter c = form -> Integer.valueOf(form);   //一个参数 和 一条语句 可以省略括弧
		System.out.println(c.converter("99"));
		
		
		//1.方法引用代替 lambda : 引用类方法
		//接口中被实现的方法参数  全部 自动传入
		Converter c1 = Integer::valueOf;
		System.out.println(c1.converter("98"));
		
		//2.引用特定对象的 实例方法
		//接口中被实现的方法参数  全部传给方法
		Converter c2 = "fkit.org"::indexOf;
		System.out.println(c2.converter("it"));
		
		//3.引用某类对象的实例方法
		//第一个参数作为调用者
		MyTest test = String::substring;
		System.out.println(test.test("abcd", 1, 3));
		
		//4.引用构造器
		YourTest y = JFrame::new;
				
	}
}
