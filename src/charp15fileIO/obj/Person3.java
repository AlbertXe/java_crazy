package charp15fileIO.obj;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person3 implements Externalizable {
	private String name;
	private int age;
	
	public Person3() {
		super();
	}
	public Person3(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person3 [name=" + name + ", age=" + age + "]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = in.readObject().toString();
		this.age = in.readInt();
	}
	
}
