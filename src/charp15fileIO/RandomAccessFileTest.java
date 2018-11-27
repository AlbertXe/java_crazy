package charp15fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws Exception {
		RandomAccessFile file = new RandomAccessFile("src/charp15fileIO/RandomAccessFileTest.java", "r");
		
		long pointer = file.getFilePointer();
		System.out.println(pointer);
		
		file.seek(500);
		byte[] b = new byte[1024];
		int len = 0;
		while( (len = file.read(b))>0){
			System.out.println(new String(b,0,len));
		}
		

	}
}
