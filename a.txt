package charp10exception;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * 
 * @ClassName:  AutoCloseTest   
 * @Description: 自动 关闭流  实现 {@link AutoCloseable} 或者 {@link Closeable}
 * @author: 谢洪伟 
 * @date:   2018年9月28日 下午4:33:08
 */
public class AutoCloseTest {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/charp10exception/AutoCloseTest.java"));
			
			PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
			String line = null;
			while ((line = br.readLine())!=null) {
				ps.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
