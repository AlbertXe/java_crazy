package charp11AWT;

import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class Layout_Box {
	Frame f = new Frame("Test");
	public void init(){
		f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
		f.add(new Button("B1"));
		f.add(new Button("B2"));
		f.setVisible(true);
		f.pack();
	}
	public static void main(String[] args) {
		new Layout_Box().init();
	}
}
