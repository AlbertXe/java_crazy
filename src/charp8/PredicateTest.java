package charp8;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * 
 * @ClassName:  PredicateTest   
 * @Description:java8 新增 Predicate 操作集合
 * @author: 谢洪伟 
 * @date:   2018年9月27日 下午3:22:07
 */
public class PredicateTest {
	public static void main(String[] args) {
		Collection books = new HashSet<>();
		books.add("轻量级javaEE企业应用实战");
		books.add("疯狂java讲义");
		books.add("疯狂ios讲义");
		books.add("疯狂ajax讲义");
		books.add("疯狂android讲义");
		//java8 为集合collection 新增了removeif(Predicate filter)方法，函数式接口，可以用lambda
		//books.removeIf(a-> ((String)a).length()<10);
		System.out.println(books);
		
		//统计出现java 图书数量
		int i = calAll(books, (a)->((String)a).contains("疯狂"));
		System.out.println(i);
		
		
	}
	
	public static int calAll(Collection books ,Predicate filter){
		int total =0;
		for (Object object:books ){
			if (filter.test(object)) {//判断对象是否满足 Predicate 条件
				total++;
			}
		}
		return total;
	}
}
