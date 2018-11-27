package charp7;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal("0.5");
		BigDecimal b2 = BigDecimal.valueOf(0.4);
		BigDecimal b3 = new BigDecimal(0.4);
		System.out.println(b1.add(b2));
		System.out.println(b3.add(b2));
		
		
	}
}
