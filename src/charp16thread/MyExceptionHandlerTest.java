package charp16thread;

/**
 * 
 * @ClassName: MyExceptionHandlerTest
 * @Description:异常处理器 处理器还是会向上传递 而不是向 try catch 解决了不会向上传播
 * @author: 谢洪伟
 * @date: 2018年12月21日 下午4:33:51
 */
public class MyExceptionHandlerTest  {
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
		int a = 5 / 0;
		System.out.println("end !");
	}

}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() + "异常： ");
		e.printStackTrace();
	}

}
