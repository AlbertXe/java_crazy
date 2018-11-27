package charp7;

import java.util.Locale;
import java.util.ResourceBundle;


public class Hello {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault(Locale.Category.FORMAT);
		ResourceBundle bundle = ResourceBundle.getBundle("mess", locale);
		System.out.println(bundle.getString("hello"));
		
	}
}
