package charp15fileIO.obj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadObj2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/charp15fileIO/obj/person.txt"));
		ArrayList<Object>  list = (ArrayList<Object>) ois.readObject();
		System.out.println(list.toString());
	}
}
