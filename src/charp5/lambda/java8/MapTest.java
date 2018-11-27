package charp5.lambda.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val"+i);
		}
		map.forEach((id,val)->System.out.println(val)); 
		
		map.computeIfPresent(3, (id,val)->id+val);  // 存在计算
		System.out.println(map.get(3));
		
		map.computeIfAbsent(23, num -> "val" + num); // 不存在就计算
		System.out.println(map.get(23));
	}
}
