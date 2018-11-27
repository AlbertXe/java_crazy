package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;

/**
 * 
 * @ClassName:  DialogTest   
 * @Description:对话框 测试   子类 {@link FileDialog}
 * @author: 谢洪伟 
 * @date:   2018年9月29日 下午3:12:38
 */
public class DialogTest {
	Frame f  = new Frame();
	Dialog d1 = new Dialog(f, "d1", true);//true 锁定 其他
	Dialog d2 = new Dialog(f, "d2", false);
	
	Button b1 = new Button("b1");
	Button b2 = new Button("b2");
	
	public void init(){
		d1.setBounds(20,30,300,400);
		d2.setBounds(20,30,300,400);
		b1.addActionListener(e -> d1.setVisible(true));
		b2.addActionListener(e -> d2.setVisible(true));
		f.add(b1);
		f.add(b2,BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogTest().init();
		
	}
}
