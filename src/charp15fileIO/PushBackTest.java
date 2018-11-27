package charp15fileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

/**
 * 
 * @ClassName:  PushBackTest   
 * @Description:推回输入流
 * @author: 谢洪伟 
 * @date:   2018年11月12日 下午3:52:01
 */
public class PushBackTest {
	public static void main(String[] args) throws Exception {
		PushbackReader pr = new PushbackReader(new FileReader("PushBackTest.java"), 60);// 推回大小60
		char[] buf = new char[32];
		String lastRead =  "";
		int len = 0;
		while ((len=pr.read(buf))>0) {
			String content = new String(buf,0,len);// 读取内容
			
		}
		
		
	}
}
