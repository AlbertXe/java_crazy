package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class Layout_BorderTest {
	public static void main(String[] args) {
		
		Frame frame = new Frame();
		frame.setLayout(new BorderLayout(60,5));
		
		frame.add(new Button("East"), BorderLayout.EAST);
		frame.add(new Button("West"), BorderLayout.WEST);
		frame.add(new Button("South"), BorderLayout.SOUTH);
		frame.add(new Button("North"), BorderLayout.NORTH);
		frame.add(new Button("Center"));
		
		frame.pack();
		frame.setVisible(true);
	}
}
