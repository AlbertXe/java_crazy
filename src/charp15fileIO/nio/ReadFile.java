package charp15fileIO.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
	public static void main(String[] args) throws Exception {
//		read("src/charp15fileIO/nio/ReadFile.java");
		read("src/charp15fileIO/nio/test.xml");
		
	}

	public static void read(String file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		
		FileChannel channel = fis.getChannel();//常用 map()  read() write()
		
		ByteBuffer buff = ByteBuffer.allocate(256);
		
		while(channel.read(buff)!=-1){
			buff.flip();// 锁定空白区
			
			Charset charset = Charset.forName("utf-8");
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer charBuffer = decoder.decode(buff);
			System.out.println(charBuffer);
			
			buff.clear();// buff 初始化，为下次读取做准备
		}
	}
}
