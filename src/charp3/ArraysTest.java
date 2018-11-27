package charp3;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * 
 * @ClassName:  ArraysTest   
 * @Description:java 8 数组新特性
 * @author: 谢洪伟 
 * @date:   2018年9月26日 上午9:25:04
 */
public class ArraysTest {
	public static void main(String[] args) {
		int[]  a = new int[]{3,4,5,6};
		int[]  a2 = new int[]{3,4,5,6};
		System.out.println(Arrays.equals(a, a2));
		
		int[] b = Arrays.copyOf(a, 6);
		System.out.println(Arrays.toString(b));
		
		Arrays.fill(b, 2,4,1);
		System.out.println(Arrays.toString(b));
		
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
		
		//java 8 并行能力
		
		int[] arr1 = new int[]{3,-4,25,16,30,18};
		Arrays.parallelSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = new int[]{3,-4,25,16,30,18};
		Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
			//left 为前一个索引处元素，right 为当前索引处元素 ，第一个元素是，left索引元素值为1
			@Override
			public int applyAsInt(int left, int right) {
				return left*right;
			}
		});
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 =new int[5];
		Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
			//operand 代表正在计算的索引
			@Override
			public int applyAsInt(int operand) {
				return operand*5;
			}
		});
		System.out.println(Arrays.toString(arr3));
		
		Arrays.parallelSetAll(arr3, (i)-> 6*i);//lammada 表达式
		System.out.println(Arrays.toString(arr3));
		
	}
}
