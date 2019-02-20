package charp16thread.group;

/**
 * 线程组
 * 
 * @ClassName: MyThread
 * @Description:
 * @author: 谢洪伟
 * @date: 2019年1月14日 下午3:23:32
 */


public class ThreadGropuTest extends Thread {
	public static void main(String[] args) {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		System.out.println(threadGroup.getName() + Thread.currentThread().getName());
	}
}


