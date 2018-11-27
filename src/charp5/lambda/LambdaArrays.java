package charp5.lambda;

import java.util.Arrays;

/**
 * 
 * @ClassName:  LambdaArrays   
 * @Description:
 * @author: 谢洪伟 
 * @date:   2018年9月26日 下午2:57:03
 */
public class LambdaArrays {
	public static void main(String[] args) {
		String[] arr1 = new String[]{"java","fkava","fkit","ios","android"};
		Arrays.parallelSort(arr1,(o1,o2)->o1.length()-o2.length());
		System.out.println(Arrays.toString(arr1));
		
		int [] arr2 = new int[]{3,-4,25,16,30,18};
		Arrays.parallelPrefix(arr2, (left,right)-> left*right);
		System.out.println(Arrays.toString(arr2));
		
		int [] arr3 = new int [10];
		Arrays.parallelSetAll(arr3, oprate ->oprate*5);
		System.out.println(Arrays.toString(arr3));
		
	}
}
