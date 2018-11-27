package charp11AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowLayoutTest {
	public static void main(String[] args) {
		
		Frame frame = new Frame();
		
		frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));// 左-有   水平间距，垂直间距
		
		for (int i = 0; i < 10; i++) {
			frame.add(new Button("button"+i));
		}
		frame.pack();//最佳大小
		frame.setVisible(true);
	}
}
