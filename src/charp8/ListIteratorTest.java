package charp8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * @ClassName:  ListIteratorTest   
 * @Description:正方向迭代
 * @author: 谢洪伟 
 * @date:   2018年9月28日 上午9:43:59
 */
public class ListIteratorTest {
	public static void main(String[] args) {
		String [] ss = {"疯狂java讲义","疯狂ios讲义","疯狂ajax讲义"};
		
		List list = new ArrayList<>();
		list.addAll(Arrays.asList(ss));// 此法造成固定长度的list ,不可删除和新增 只可遍历
		
		ListIterator iterator = list.listIterator();
		while (iterator.hasNext()) {
			String s = (String) iterator.next();
			System.out.println(s);
		}
		//反向迭代
		while (iterator.hasPrevious()) {
			String object = (String) iterator.previous();
			System.out.println(object);
		}
		
		
	}
}
