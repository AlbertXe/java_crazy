package charp18classLoad.reflect;

public class User {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> forName = Class.forName("charp18classLoad.reflect.User");
		System.out.println(forName);
	}

}
