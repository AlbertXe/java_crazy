package charp16thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @ClassName: BlockingQueueTest
 * @Description:阻塞 队列
 * @author: 谢洪伟
 * @date: 2018年12月21日 下午3:38:46
 */
public class BlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Object> queue = new ArrayBlockingQueue<>(2);
		queue.put(1);
		queue.put(2);
		queue.put(3); // 满了，put 会阻塞; add 会抛异常 offer() 返回false;
		// 对应 take() , remove() poll()
		System.out.println(4);
	}
}
