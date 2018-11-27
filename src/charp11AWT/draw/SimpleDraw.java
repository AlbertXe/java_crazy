package charp11AWT.draw;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

public class SimpleDraw {
	private final String RECT_SHAPE = "rect";
	private final String OVAL_SHAPE = "oval";
	Frame f = new Frame("简单绘制");
	private Button rect = new Button("绘制矩形");
	private Button oval = new Button("绘制椭圆");
	private MyCanvas canvas = new MyCanvas();
	private String shape ="";
	
	public void init(){
		Panel p = new Panel();
		rect.addActionListener(e -> {
			shape = RECT_SHAPE;
			canvas.repaint();
		});
		oval.addActionListener(e -> {
			shape = OVAL_SHAPE;
			canvas.repaint();
		});
		p.add(rect);
		p.add(oval);
		canvas.setPreferredSize(new Dimension(250, 250));
		f.add(canvas);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SimpleDraw().init();
	}
	
	class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			Random random = new Random();
			if (shape.equals(RECT_SHAPE)) {
				g.setColor(new Color(200, 100, 80));
				g.drawRect(random.nextInt(200), random.nextInt(100), 40, 60);
			}
			if (shape.equals(OVAL_SHAPE)) {
				g.setColor(new Color(80, 100, 200));
				g.fillOval(random.nextInt(200), random.nextInt(120), 50, 40);
			}
		}
		
	}
}

