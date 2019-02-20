package charp16thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		Runnable target = () -> {
			System.out.println(Thread.currentThread().getName() + "执行了");
		};

		pool.submit(target);
		pool.submit(target);

	}
}
