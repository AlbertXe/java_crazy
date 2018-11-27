package charp10exception;

import java.awt.SecondaryLoop;

/**
 * 
 * @ClassName:  PrintStackTrackTest   
 * @Description:
 * @author: 谢洪伟 
 * @date:   2018年9月28日 下午4:59:35
 */
public class PrintStackTrackTest {
	public static void main(String[] args) {
		first();
	}

	private static void first() {
		second();
	}

	private static void second() {
		third();
	}

	private static void third() {
		throw new SelfException("自定义异常");
		
	}
}

class SelfException extends RuntimeException{
	public SelfException(){
	}
	public SelfException(String msg){
		super(msg);
	}
	
}
