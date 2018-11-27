package charp15fileIO.obj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 
 * @ClassName:  Person   
 * @Description:自定义序列化  ： 
 * @author: 谢洪伟 
 * @date:   2018年11月21日 下午4:32:16
 */
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
//	private transient int age;
	private int age;
	
	
	public Person(String name, int age) {
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
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.writeObject(new StringBuffer(name).reverse());
		oos.writeInt(age+1);
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException{
		this.name = (String) ois.readObject().toString();
		this.age = ois.readInt();
	}
	

}
