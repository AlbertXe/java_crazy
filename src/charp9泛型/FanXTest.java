package charp9泛型;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.text.DefaultEditorKit.CopyAction;

public class FanXTest {
	//泛型构造器
	public <T> FanXTest(T t){
	}
	
	//这个方法没问题 ，但是应用太窄。 怎么办？用泛型方法 ，但是不确定泛型参数  是不能做增加操作的。
	// Collection<?> c  也不可以，java不允许 将对象放进位置类型的集合中
	static void formColToArr(Object[] o ,Collection<Object> c){
		for(Object a : o){
			c.add(a);
		}
	}
	//泛型方法 解决烦恼
	static <T> void formColToArr2(T[] o,Collection<T> c){
		for (T t : c) {
			c.add(t);
		}
	}
	
	//泛型方法 和通配符 结合 ，这个就不能 往 集合c 中添加元素
	static <T> void test(Collection<? extends T> c ,Collection<T> c2){
		
	}
	// 使用泛型方法代替 通配符 会好一点， 两个几个都可以添加元素
	static <T,S extends T> void test1(Collection<S> s ,Collection<T> t){
		
	}
	
	
	// 4. 复制存在问题 ,返回最后一个元素， 类型丢失  el: desc:Number   src:Integer  
	static <T> T copy(Collection<T> desc,Collection<? extends T> src){
		T last =null;
		for (T t : src) {
			last = t;
			desc.add(last);
		}
		return last;
	}
	//5. 解决4 问题。 ？ super type  表示 本身或 父类
	static <T> T copy1(List<? super T> desc,List<T> src){
		T last =null;
		for (T t : src) {
			last =t;
			desc.add(t);
		}
		return last;
	}
	
	public static void main(String[] args) {
		List<Number> nu = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		
		Integer copy =  (Integer) copy(nu, in);// 原来元素 是 integer ，变成了Number ,丢失 in 集合类型
		Integer copy1 = copy1(nu, in);
	}
}
