package charp7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileTest {
	public static void main(String[] args) throws Throwable {
		String property = System.getProperty("user.dir");
		System.out.println(property);
		
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		System.out.println(path);
		Scanner s = new Scanner(new File("src/charp7/"+"ScannerFileTest.java"));
		
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		
		
	}
}
