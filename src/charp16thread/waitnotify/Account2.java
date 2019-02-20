package charp16thread.waitnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @ClassName: Account2
 * @Description: lock 和 condition 组合 控制线程 通信
 * @author: 谢洪伟
 * @date: 2018年12月21日 下午3:21:03
 */
public class Account2 {
	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();

	private String no;
	private double balance;
	private boolean flag = false; // 可取

	public Account2(String no, double balance) {
		this.no = no;
		this.balance = balance;
	}

	public void draw(double money) {
		lock.lock();
		try {
			if (!flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱" + money);
				balance -= money;
				System.out.println("余额：" + balance);
				flag = false;
				cond.signalAll();
			}
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}

	}

	public void deposit(double money) {
		lock.lock();

		try {
			if (flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName() + "存钱" + money);
				balance += money;
				System.out.println("余额：" + balance);
				flag = true;
				cond.signalAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}

	}

}
