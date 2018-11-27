package charp8;

import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap map = new LinkedHashMap<>();
		map.put("语文", 60);
		map.put("英语",80);
		map.put("数学", 100);
		map.forEach((key,value) -> System.out.println(key +"=" + value));// 遍历 map
		
	}
}
