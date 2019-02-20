package charp16thread;

import java.util.concurrent.RecursiveTask;

/**
 * 
 * @ClassName: CalcTask
 * @Description:
 * @author: 谢洪伟
 * @date: 2018年12月24日 上午9:21:55
 */
public class CalcTask extends RecursiveTask<Integer> {
	private final int num = 20;
	private int[] attr;
	private int start;
	private int end;

	public CalcTask(int[] attr, int start, int end) {
		this.attr = attr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if (end - start < num) {
			for (int i = start; i < end; i++) {
				sum += attr[i];
			}
			return sum;
		} else {
			int middle = (start + end) / 2;

			CalcTask c1 = new CalcTask(attr, start, middle);
			CalcTask c2 = new CalcTask(attr, middle, end);

			c1.fork();
			c2.fork();
			return c1.join() + c2.join();
		}
	}

}
