package charp8;

import java.util.ArrayDeque;

/**
 * 
 * @ClassName:  ArrayDequeTest   
 * @Description:双端队列    可做栈使用
 * @author: 谢洪伟 
 * @date:   2018年9月28日 上午10:17:04
 */
public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque que = new ArrayDeque<>();
		
		que.push("疯狂java");  //加入 到栈顶
		que.push("疯狂ios");
		que.push("疯狂ajax");
		System.out.println(que);
		
		System.out.println(que.peek());
		
		System.out.println(que.pop());// 移除栈顶元素
		
		
	}
}
