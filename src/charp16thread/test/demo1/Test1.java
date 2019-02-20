package charp16thread.test.demo1;

public class Test1 {
	public static void main(String[] args) {
		String[] nums = new String[52];
		String[] chas = new String[26];
		for (int i = 0; i < 52; i++) {
			nums[i] = String.valueOf(i + 1);
			if (i < 26) {
				chas[i] = String.valueOf((char) (i + 65));
			}
		}
		// System.out.println(Arrays.toString(nums));
		// System.out.println(Arrays.toString(chas));
		Printer printer = new Printer(nums, chas);
		new Thread1(printer).start();
		new Thread2(printer).start();

	}
}

class Printer<T> {
	int count;
	T[] t1;
	T[] t2;
	boolean flag = false; // true 为输出打印

	public Printer(T[] t1, T[] t2) {
		this.t1 = t1;
		this.t2 = t2;
	}


	public synchronized void print1() throws InterruptedException {// 12A34
		for (int i = 0; i < t1.length; i++) {

			if (count % 3 == 2) {
				wait();
				i = i - 1;
			}
			else {
				System.out.println(Thread.currentThread().getName() + "====" + t1[i]);
				count++;
				notifyAll();
			}
		}
	}

	public synchronized void print2() throws InterruptedException {// AB
		for (int i = 0; i < t2.length; i++) {// 0-26
			if (count % 3 == 2) { // count 被3 整除 0 1 2
				System.out.println(Thread.currentThread().getName() + "====" + t2[i]);
				count++;
				notifyAll();
			} else {
				wait();
				i = i - 1;
			}
		}

	}
}

class Thread1<T> extends Thread {
	Printer printer;

	public Thread1(Printer printer) {
		this.printer = printer;
	}

	public void run() {
		try {
			printer.print1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
}

class Thread2<T> extends Thread {
	Printer printer;

	public Thread2(Printer printer) {
		this.printer = printer;
	}

	public void run() {
		try {
			printer.print2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
}