package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

/**
 * 
 * @ClassName:  Layout_Grid   
 * @Description:	行列  单元格布局
 * @author: 谢洪伟 
 * @date:   2018年9月29日 上午9:55:10
 */
public class Layout_Grid {
	public static void main(String[] args) {
		
		Frame f = new Frame("计算器");// 默认是 borderLayout
		Panel p1 = new Panel();
		p1.add(new TextField(30));
		f.add(p1,BorderLayout.NORTH);
		
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(3, 5,4,4));
		String[] names = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","."};
		for (String name: names){
			p2.add(new Button(name));
		}
		
		f.add(p2);// 默认居中
		f.pack();
		f.setVisible(true);
		
	}
}
