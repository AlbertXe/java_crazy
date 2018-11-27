package charp11AWT;

import java.awt.Button;
import java.awt.Frame;

/**
 * 
 * @ClassName:  Layout_null   
 * @Description:绝对定位  ，丧失平台移植性
 * @author: 谢洪伟 
 * @date:   2018年9月29日 下午2:24:40
 */
public class Layout_null {
	Frame f = new Frame("Test");
	Button b1 = new Button("B1");
	Button b2 = new Button("B2");
	
	
	public void init(){
		f.setLayout(null);
		//设置 位置  大小
		b1.setBounds(20, 30, 90, 28);
		b2.setBounds(50, 45, 120, 35);
		f.add(b1);
		f.add(b2);
		f.setBounds(50,59,200,100);
//		f.pack();
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new Layout_null().init();
	}
}
