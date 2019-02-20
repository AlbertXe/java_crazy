package charp16thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @ClassName: BlockingQueueTest1
 * @Description:3 个生成 一个消费
 * @author: 谢洪伟
 * @date: 2018年12月21日 下午3:48:37
 */
public class BlockingQueueTest1 {
	public static void main(String[] args) {
		BlockingQueueTest1 test = new BlockingQueueTest1();
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
		test.new Producter(queue).start();
		test.new Producter(queue).start();
		test.new Consumer(queue).start();
		test.new Consumer(queue).start();
		test.new Consumer(queue).start();
	}

	class Producter extends Thread {
		private BlockingQueue<String> queue;

		public Producter(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			String[] subjects = { "java", "python", "ruby" };

			for (int i = 0; i < 100; i++) {
				try {
					System.out.println(getName() + " ready product");
					sleep(200);
					queue.put(subjects[i % 3]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName() + "finish product" + queue);
			}
		}
	}

	class Consumer extends Thread {
		private BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}


		@Override
		public void run() {
			while (true) {
				try {
					System.out.println(getName() + "ready consumer");
					sleep(20);
					queue.take();
					System.out.println(getName() + "finish consumer" + queue);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
