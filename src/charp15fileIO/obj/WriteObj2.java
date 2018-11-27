package charp15fileIO.obj;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObj2 {
	public static void main(String[] args) throws IOException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/charp15fileIO/obj/person.txt"));
		Person2 person = new Person2("谢洪伟", 27);
		
		oos.writeObject(person);
	}
}
