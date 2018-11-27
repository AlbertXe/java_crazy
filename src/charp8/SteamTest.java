package charp8;

import java.util.stream.IntStream;

/**
 * 
 * @ClassName:  SteamTest   
 * @Description:java8 新特性
 * @author: 谢洪伟 
 * @date:   2018年9月27日 下午4:15:54
 */
public class SteamTest {
	public static void main(String[] args) {
		IntStream is = IntStream.builder().add(20).add(13).add(-2).add(18).build();

		//System.out.println("最大值："+is.max().getAsInt());
	//	System.out.println("总和："+is.sum());
	//	System.out.println("平均数："+is.average());
		
//		System.out.println("所有元素平方是否都大于20："+is.allMatch(a -> a*a>20));
	//	System.out.println("任何元素平方大于20："+is.anyMatch(a -> a*a>20));
		
		IntStream map = is.map(a -> a*2+1);
		map.forEach(e -> System.out.println(e));
		
	}
}
