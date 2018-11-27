package charp8;

import java.util.PriorityQueue;

/**
 * 
 * @ClassName:  PriorityQueueTest   
 * @Description: 按照元素 大小排序 而不是队列的：FIFO
 * @author: 谢洪伟 
 * @date:   2018年9月28日 上午10:07:05
 */
public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue<>();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(18);
		pq.offer(20);
		System.out.println(pq);
		System.out.println(pq.poll());
		
		
	}
}
