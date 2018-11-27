package charp15fileIO.obj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OrientationTest {
	
	public static void writeObj(String path,Object obj) throws IOException, IOException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
	}
	
	public static Object readObject(String path) throws IOException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		Orientation ori = (Orientation) ois.readObject();
		return ori;
	}
	
	public static void main(String[] args) {
		try {
			String path = "src/charp15fileIO/obj/orientation.txt";
			Orientation obj = Orientation.HORIZENTAL;
			writeObj(path , obj);
			Orientation ori = (Orientation) readObject(path);
			System.out.println(ori);// Orientation里面的 realResolve 注释结果就会不同
			System.out.println(obj);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
