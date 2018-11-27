package charp8;

import java.util.EnumSet;

public class EnumSetTest {
	public static void main(String[] args) {
		EnumSet set1 = EnumSet.allOf(Season.class);
		System.out.println(set1);
		
		EnumSet<Season> set2 = EnumSet.of(Season.SUMMER, Season.FALL);
		System.out.println(set2);
		
		EnumSet<Season> set3 = EnumSet.complementOf(set2);//补余
		System.out.println(set3);
		
	}
}

enum Season{
	SPRING,SUMMER,FALL,WINTER;
}