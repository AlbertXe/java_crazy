package charp16thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 并行计算 递归
 * 
 * @ClassName: ForkJoinPoolTest
 * @Description:
 * @author: 谢洪伟
 * @date: 2019年1月14日 下午4:03:15
 */
public class ForkJoinPoolTest {
	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		System.out.println(pool.getParallelism());
		
		pool.submit(new PrintTask(0, 300));
		pool.awaitTermination(2, TimeUnit.SECONDS);

		pool.shutdown();

	}
}

class PrintTask extends RecursiveAction {
	private final int SIZE = 50;
	private int start;
	private int end;

	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public void compute() {
		if (end - start < SIZE) {
			for (int i = start; i < end; i++) {
				System.err.println(Thread.currentThread().getName() + "====" + i);
			}
		} else {
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);

			left.fork();
			right.fork();

		}
	}

}
