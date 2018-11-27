package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;

/**
 * 
 * @ClassName:  EventTest   
 * @Description: 事件 - 监听器 - 处理  -Dfile.encoding=GB18030 乱码问题
 * @author: 谢洪伟 
 * @date:   2018年9月29日 下午3:43:09
 */
public class EventTest {
	Frame f = new Frame();
	Button b = new Button("事件测试");
	TextField tf = new TextField();
	
	public void init(){
		b.addActionListener(e ->{
			System.out.println("用户单击");
			tf.setText("Hello World");
		});
		f.add(tf);
		f.add(b,BorderLayout.NORTH);
		f.setVisible(true);
		f.pack();
		
	}
	
	
	public static void main(String[] args) {
		new EventTest().init();
	}
}
