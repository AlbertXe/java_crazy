package charp5.lambda;

public class LambdaTest {
	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		};
		
	}
}
