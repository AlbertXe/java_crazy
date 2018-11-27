package charp11AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;

public class FrameTest {
	public static void main(String[] args) {
		Frame frame = new Frame("测试");
		
//		Panel panel = new Panel();
		
		ScrollPane panel = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		panel.add(new TextField(20));
		panel.add(new Button("单击"));
		
		frame.add(panel);
		
		frame.setBounds(30, 30, 250, 300);
		frame.setVisible(true);
		
	}
}
