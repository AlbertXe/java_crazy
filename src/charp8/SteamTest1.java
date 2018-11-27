package charp8;

import java.util.Collection;
import java.util.HashSet;

public class SteamTest1 {
	public static void main(String[] args) {
		Collection books = new HashSet<>();
		books.add("轻量级javaEE企业应用实战");
		books.add("疯狂java讲义");
		books.add("疯狂ios讲义");
		books.add("疯狂ajax讲义");
		books.add("疯狂android讲义");
		
		long count = books.stream().filter(a -> ((String)a).contains("java")).count();
		System.out.println(count);
		
		//先调用 stream().maptoInt() 获取原有的stream 对应的 intStream
		books.stream().mapToInt(a ->((String)a).length()).forEach(System.out::println);
		
	}
}
