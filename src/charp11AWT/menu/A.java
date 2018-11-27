package charp11AWT.menu;

public class A {
	private String nameSpace;
	
	String nameSpace(){
		if (nameSpace == null) {
			nameSpace = this.getClass().getName();
		}
		return nameSpace;
	}
}
