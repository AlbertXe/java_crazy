package charp16thread;

public class ThreadLocalTest {
	public static void main(String[] args) {
		Account account = new Account("初始账户");
		new MyTest(account, "线程甲").start();
		new MyTest(account, "线程乙").start();
	}
}

class Account {
	ThreadLocal<String> name = new ThreadLocal<>();

	public Account(String name) {
		this.name.set(name);
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getName() {
		return this.name.get();
	}
}

class MyTest extends Thread {
	private Account account;

	public MyTest(Account account,String name) {
		super(name);
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				account.setName(getName());// 账户名 改为线程名
			}
			System.out.println(account.getName() + "账户的i=" + i);
		}

	}
}