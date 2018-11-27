package charp3;

import java.util.Arrays;

/**
 * 
 * @ClassName:  Num2Rmb   
 * @Description:数字转人名币读法
 * @author: 谢洪伟 
 * @date:   2018年9月26日 上午10:02:04
 */
public class Num2Rmb {
	private String[] hanStr = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	private String[] unitStr = new String[]{"十","百","千"};
	
	/**
	 * 将浮点数变为整数和小数
	 */
	public String[] divide(float a){
		long zheng = (long) a;
		long xiao = Math.round((a-zheng)*100);//最接近浮点数的  long
		return new String[]{zheng+"",String.valueOf(xiao)};
	}
	
	/**
	 * 将数字字符串变成汉字字符串
	 * @return
	 */
	public String toHanStr(String numStr){
		String result = "";
		int length = numStr.length();
		for (int i = 0; i < length; i++) {
			//将字符 '4' 转换 数字 4  相差48
			int num = numStr.charAt(i)-48;
			//num 不是最后一位且 num ！=0
			if (i!=length-1 && num !=0) {
				result += hanStr[num]+unitStr[length-2-i];
			}else {
				result += hanStr[num];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Num2Rmb n = new Num2Rmb();
		System.out.println(Arrays.toString(n.divide(1234.567f)));
		
		System.out.println(n.toHanStr("7109"));
		
		
	}
}
