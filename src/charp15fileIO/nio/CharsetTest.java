package charp15fileIO.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;
import java.util.function.BiConsumer;

/**
 * 
 * @ClassName:  CharsetTest   
 * @Description:java 支持字符集
 * @author: 谢洪伟 
 * @date:   2018年12月12日 下午4:43:22
 */
public class CharsetTest {
	public static void main(String[] args) {
		charsets();
		Object encoding = System.getProperties().get("file.encoding");
		System.out.println(encoding.toString());
	}
	
	public static void charsets(){
		SortedMap<String, Charset> map = Charset.availableCharsets();
		map.forEach((a,b)->{
			System.out.println(a+"="+b);
		});
	}
}
