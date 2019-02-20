package charp16thread.exhandler;

public class ExHandlerTest {
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 5 / 0;
		System.out.println("over");
	}
}

class MyExHandler implements Thread.UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("找到异常");
		System.out.println(t + "" + e);
	}
}
