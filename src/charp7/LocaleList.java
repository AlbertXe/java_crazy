package charp7;

import java.util.Locale;

/**
 * 
 * @ClassName:  LocaleList   
 * @Description:本地支持语言环境
 * @author: 谢洪伟 
 * @date:   2018年9月27日 上午11:07:55
 */
public class LocaleList {
	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale locale : locales) {
			System.out.println(locale.getDisplayCountry()+"="+locale.getCountry());
			System.out.print(locale.getDisplayLanguage()+"="+locale.getLanguage());
		}
		
		
	}
}
