package charp8;

import java.util.WeakHashMap;

/**
 * 
 * @ClassName:  WeakHashMapTest   
 * @Description:map key 对对象的 弱引用
 * @author: 谢洪伟 
 * @date:   2018年9月28日 下午1:47:45
 */
public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap whm = new WeakHashMap<>();
		whm.put(new String("语文"), new String("及格"));//WeakHashMap 来保存 key  匿名字符串对象  弱引用
		whm.put(new String("英语"), new String("良好"));
		whm.put(new String("数学"), new String("优秀"));
		
		whm.put("java", new String("良好"));// 系统缓存的字符串对象
		System.out.println(whm);
		
		System.gc();
		System.runFinalization();
		
		System.out.println(whm);
		
		
		
		
	}
}
