package charp9泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName:  ArrErr   
 * @Description:java  非优秀设计
 * @author: 谢洪伟 
 * @date:   2018年9月28日 下午2:33:06
 */
public class ArrErr {
	public static void main(String[] args) {
		Integer[] integers = new Integer[5];		
		Number[] numbers = integers;
		numbers[0] = 0.5; // 这一步运行 会报错  ，java 将Integer 赋值给 number 显然不是安全的设计
		
		List<Integer> list = new ArrayList<>();
		//List<Number> numbers2 = list;  这一步编译就回报错
		//泛型设计原则： 编译无警告，运行就无异常
		
		
	}
}
