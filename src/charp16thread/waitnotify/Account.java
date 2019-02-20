package charp16thread.waitnotify;

/**
 * 
 * @ClassName: Account
 * @Description:1.no 2.balance 3.flag 4.drwa() 5.deposit()
 * @author: 谢洪伟
 * @date: 2018年12月21日 下午2:25:33
 */
public class Account {
	private String no;
	private double balance;
	private boolean flag = false; // 取钱操作 true 可取

	public Account(String no, double balance) {
		this.balance = balance;
		this.no = no;
	}

	public double getBalance() {
		return this.balance;
	}

	public synchronized void draw(double money) {
		try {
			if (!flag)
				wait();
			else {
				System.out.println(Thread.currentThread().getName() + "执行取钱操作" + money);
				balance -= money;
				System.out.println("余额：" + balance);

				flag = false;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void deposit(double money) {
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + "存钱操作" + money);
				balance += money;
				System.out.println("余额：" + balance);
				flag = true;
				notifyAll();

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
