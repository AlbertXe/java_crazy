package charp16thread.waitnotify;

public class DrawTest {
	public static void main(String[] args) {
		DrawTest drawTest = new DrawTest();
		Account account = new Account("999", 0);
		drawTest.new DrawThread("取钱甲", account, 800L).start();
		drawTest.new DepositeThread("存钱者 已", account, 800).start();
		drawTest.new DepositeThread("存钱者 丙", account, 800).start();
		drawTest.new DepositeThread("存钱者 丁", account, 800).start();
	}

	private class DrawThread extends Thread {
		private Account account;
		private double money;

		public DrawThread(String name, Account account, double money) {
			super(name);
			this.account = account;
			this.money = money;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				account.draw(money);
			}
		}
	}

	private class DepositeThread extends Thread {
		private Account account;
		private double money;

		public DepositeThread(String name, Account account, double money) {
			super(name);
			this.account = account;
			this.money = money;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				account.deposit(money);
			}
		}

	}
}
