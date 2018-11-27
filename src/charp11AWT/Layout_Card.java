package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.LineNumberInputStream;

public class Layout_Card {
	Frame f = new Frame("测试窗口");
	Panel p1 = new Panel();
	String[] names = {"第一张","第二张","第三张","第四张","第五张"};
	
	public void init() {
		final CardLayout c = new CardLayout();
		p1.setLayout(c);
		for (int i = 0; i < names.length; i++) {
			p1.add(names[i], new Button(names[i]));
		}
		
		Panel p = new Panel();
		ActionListener listener = e -> {
			switch (e.getActionCommand()) {
			case "上一张":
				c.previous(p1);
				break;
			case "下一张":
				c.next(p1);
				break;
			case "第一张":
				c.first(p1);
				break;
			case "最后一张":
				c.last(p1);
				break;
			case "第三张":
				c.show(p1, "第三张");
				break;
			}
		};
		
		// 控制显示上一张的按钮
		Button previous = new Button("上一张");
		previous.addActionListener(listener);
		
		Button next = new Button("下一张");
		next.addActionListener(listener);
		
		Button first = new Button("第一张");
		first.addActionListener(listener);
		
		Button last = new Button("最后一张");
		last.addActionListener(listener);
		
		Button third = new Button("第三张");
		third.addActionListener(listener);
		
		p.add(previous);p.add(next);p.add(first);p.add(last);p.add(third);
		f.add(p,BorderLayout.SOUTH);
		f.add(p1);
		f.pack();
		f.setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new Layout_Card().init();
	}
}
