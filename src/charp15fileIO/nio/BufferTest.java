package charp15fileIO.nio;

import java.nio.Buffer;
import java.nio.CharBuffer;
/**
 * 
 * @ClassName:  BufferTest   
 * @Description:NIO 测试
 * @author: 谢洪伟 
 * @date:   2018年11月22日 上午10:10:09
 */
public class BufferTest {
	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(500);
		System.out.println("capacity="+buffer.capacity());
		System.out.println("limit="+buffer.limit());
		System.out.println("position="+buffer.position());
		
		buffer.put('a');
		buffer.put('b');
		buffer.put('c');
		System.out.println("放入三个元素之后position="+buffer.position());
		
		buffer.flip();// 取数据做准备：position 回到0处， limit 到原先position处， 将空间 空的锁定了
		System.out.println("flip之后position="+buffer.position());
		System.out.println("flip之后limit="+buffer.limit());
		
		System.out.println("取出第一个数据="+buffer.get());
		System.out.println("取出第一个数据之后position="+buffer.position());
		
		buffer.clear();//写入数据做准备：position 回到0 ，limit 到 capacity; buffer数据继续存在。
		System.out.println("clear之后limit= "+buffer.limit());
		System.out.println("clear之后 position = "+buffer.position());
		System.out.println("clear之后，缓冲区并没有被删除，取出第三个元素 ="+buffer.get(2));
		System.out.println("执行绝对读取之后 position = "+buffer.position());
		
		
		
	}
}
