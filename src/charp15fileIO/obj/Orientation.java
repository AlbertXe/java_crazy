package charp15fileIO.obj;

import java.io.Serializable;

/**
 * 
 * @ClassName:  Orientation   
 * @Description: jdk1.5 之前 非 enum 的枚举
 * @author: 谢洪伟 
 * @date:   2018年11月21日 下午5:09:54
 */
public class Orientation implements Serializable {
	private int value;
	private Orientation(int value){
		this.value = value;
	}
	public static final Orientation HORIZENTAL = new Orientation(1);
	public static final Orientation VERTICAL = new Orientation(2);
	
//	private Object readResolve(){
//		if (value ==1) return HORIZENTAL;
//		if (value ==2) return VERTICAL;
//		return null;
//	}
}
