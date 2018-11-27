package charp15fileIO.obj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObj {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/charp15fileIO/obj/person.txt"));
		Person  person = (Person) ois.readObject();
		System.out.println(person.toString());
	}
}
