package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.Box;

/**
 * 
 * @ClassName:  BoxSpaceTest   
 * @Description:测试 Box 布局的 间距   glue : 双方向拉伸   strut : 单方向    rigid : 固定
 * @author: 谢洪伟 
 * @date:   2018年9月29日 下午2:43:18
 */
public class BoxSpaceTest {
	Frame f = new Frame();
	Box horizontal = Box.createHorizontalBox();
	Box vertical = Box.createVerticalBox();
	
	public void init(){
		
		horizontal.add(new Button("===1"));
		horizontal.add(Box.createHorizontalGlue());
		horizontal.add(new Button("===2"));
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(new Button("===3"));
		
		vertical.add(new Button("|||||1"));
		vertical.add(Box.createVerticalGlue());
		vertical.add(new Button("|||||2"));
		vertical.add(Box.createVerticalStrut(10));//垂直方向不可拉伸 ，高度 10 
		vertical.add(new Button("|||||3"));
		
		f.add(horizontal,BorderLayout.NORTH);
		f.add(vertical);
		f.pack();
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BoxSpaceTest().init();
	}
}
