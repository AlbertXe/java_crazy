package charp7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemTest {
	public static void main(String[] args) {
		Map<String, String> map = System.getenv();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key+":"+map.get(key));
		}
		
		Properties properties = System.getProperties();
		try {
			properties.store(new FileOutputStream("props.txt"), "System properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String s = "java";
		String s2 ="java";
		// 每个对象唯一
		int code = System.identityHashCode(s);
		int code2 = System.identityHashCode(s2);
		System.out.println(code+"="+code2);
		
	}
}
