package charp7;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextInt(10));
		
		ThreadLocalRandom random2  = ThreadLocalRandom.current();
		System.out.println(random2.nextInt(1, 20));
		
	}
}
