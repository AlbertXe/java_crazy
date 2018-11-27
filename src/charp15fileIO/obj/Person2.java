package charp15fileIO.obj;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Person2 implements Serializable {
	private String name;
	private int age;
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + "]";
	};
	
	/**
	 * 程序在 序列化之前会调用 该方法
	 * @return
	 */
	private Object writeReplace(){
		ArrayList<Object> list = new ArrayList<>();
		list.add(name);
		list.add(age);
		return list;
	}

}
