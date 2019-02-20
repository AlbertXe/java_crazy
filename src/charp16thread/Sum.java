package charp16thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Sum {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] attr = new int[100];
		Random r = new Random();
		int total = 0;
		for (int i = 0; i < attr.length; i++) {
			int temp = r.nextInt(20);
			total += (attr[i] = temp);
		}
		System.out.println(total);

		ForkJoinPool pool = ForkJoinPool.commonPool();
		ForkJoinTask<Integer> task = pool.submit(new CalcTask(attr, 0, 100));
		System.out.println(task.get());

		pool.shutdown();

	}
}
