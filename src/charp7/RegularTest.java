package charp7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName:  RegularTest   
 * @Description:Pattern  Matcher
 * @author: 谢洪伟 
 * @date:   2018年9月27日 上午10:27:53
 */
public class RegularTest {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("a*b");//讲一个字符串 编译成 pattern 对象
		Matcher matcher = p.matcher("aaab");// 使用pattern 对象创建matcher 对象
		boolean b = matcher.matches();
		System.out.println(b);
		
		// 模拟网络爬虫
		String str = "我想求购一本java ，联系我 13500006666，交朋友 联系我 13611119090，求购二手点按 电话15812344321";
//		boolean matches = Pattern.matches("((13\\d)|(15\\d))\\d{8}", str);
		Matcher matcher2 = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
		while (matcher2.find()) {
			System.out.println(matcher2.group());//返回上一次匹配的子串
			
		}
		
		
		
	}
}
