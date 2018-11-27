package charp15fileIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 
 * @ClassName:  RandomAccessFileTest2   
 * @Description:追加seek 后面的会覆盖
 * @author: 谢洪伟 
 * @date:   2018年11月21日 下午3:34:16
 */
public class RandomAccessFileTest2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/charp15fileIO/appender.txt", "rw");
		long length = raf.length();
		raf.seek(length);
		raf.write("追加的内容\r\n".getBytes());
		
	}
}
