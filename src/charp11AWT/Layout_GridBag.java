package charp11AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Layout_GridBag {
	private Frame f = new Frame();
	GridBagLayout gb = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	private Button [] bs = new Button[10];
	
	public void init(){
		f.setLayout(gb);
		for (int i = 0; i < bs.length; i++) {
			bs[i] = new Button("按钮"+i);
		}
		
		gbc.fill = GridBagConstraints.BOTH; //横向和纵向 扩大
		gbc.weightx = 1; // 默认是 0 ， 就是动态变化
		addButton(bs[0]);
		addButton(bs[1]);
		addButton(bs[2]);
		gbc.gridwidth = GridBagConstraints.REMAINDER;// 横向 最后一个组件
		addButton(bs[3]);
		
		gbc.weightx = 0 ;// 横向不会扩大
		addButton(bs[4]);
		gbc.gridwidth =2 ; // 跨越 两个
		addButton(bs[5]);
		
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addButton(bs[6]);
		
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc. weighty = 1;
		addButton(bs[7]);
		
		gbc.weighty = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		addButton(bs[8]);
		addButton(bs[9]);
		
		f.pack();
		f.setVisible(true);
		
		
	}
	
	private void addButton(Button button) {
		gb.setConstraints(button, gbc);
		f.add(button);
	}

	public static void main(String[] args) {
		
		new Layout_GridBag().init();
		
		
	}
}
