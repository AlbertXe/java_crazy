package charp5.lambda.java8;

import java.util.Objects;
import java.util.function.Predicate;

public class MainTest {
	public static void main(String[] args) {
		Predicate<String> flag = s ->s.length()>0 ;
		System.out.println(flag.test("hello"));
		System.out.println(flag.negate().test("hello")); // 相反
		
		Predicate<Boolean> isNull = Objects::isNull; 
		System.out.println(isNull.test(null)); // 判断对象是否空
	}
}
