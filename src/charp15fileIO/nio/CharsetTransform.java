package charp15fileIO.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 
 * @ClassName:  CharsetTransform   
 * @Description:字节和字符的转换
 * @author: 谢洪伟 
 * @date:   2018年12月12日 下午4:55:29
 */
public class CharsetTransform {
	public static void main(String[] args) {
		try {
			transform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void transform() throws Exception{
		Charset charset = Charset.forName("utf-8");
		CharsetDecoder decoder = charset.newDecoder();
		CharsetEncoder encoder = charset.newEncoder();
		
		CharBuffer charBuffer = CharBuffer.allocate(8);
		charBuffer.put('孙');
		charBuffer.put('悟');
		charBuffer.put('空');
		charBuffer.flip();// 感觉这个锁定没起到作用
		ByteBuffer byteBuffer = encoder.encode(charBuffer);
		for (int i = 0; i < byteBuffer.capacity()-6; i++) {
			System.out.print(byteBuffer.get(i)+" ");
		}
		System.out.println(decoder.decode(byteBuffer));
		
		
		
	}
}
