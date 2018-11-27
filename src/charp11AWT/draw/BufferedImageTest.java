package charp11AWT.draw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JColorChooser;
import javax.swing.JDialog;

/**
 * 
 * @ClassName:  BufferedImageTest   
 * @Description:处理图像 位图   也可以缓冲
 * @author: 谢洪伟 
 * @date:   2018年10月17日 上午9:22:15
 */
public class BufferedImageTest {
	private final int WIDTH = 500;
	private final int HEIGHT = 400;
	private int prex = -1;
	private int prey = -1;
	
	PopupMenu popupMenu = new PopupMenu();// 鼠标右击
	MenuItem red = new MenuItem("red");
	MenuItem green = new MenuItem("green");
	MenuItem blue = new MenuItem("blue");
	
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	
	private Frame f = new Frame();
	private DrawCanvas canvas = new DrawCanvas();
	private Color color = new Color(255,0,0);
	
	public void init(){
		ActionListener listener = e ->{
//			if (e.getActionCommand() .equals("green")) {
//				color = new Color(0,255,0);
//			}
//			if (e.getActionCommand().equals("red")) {
//				color = new Color(255,0,0);
//			}
//			if (e.getActionCommand().equals("blue")) {
//				color = new Color(0,0,255);
//			}
			// 颜色面板
			JColorChooser colorChooser = new JColorChooser(color);
			JDialog jDialog = JColorChooser.createDialog(f, "颜色选择器", false, colorChooser,ae-> color = colorChooser.getColor(), null);
			jDialog.setVisible(true);
		};
		red.addActionListener(listener);
		green.addActionListener(listener);
		blue.addActionListener(listener);
		popupMenu.add(red);
		popupMenu.add(green);
		popupMenu.add(blue);
		
		canvas.add(popupMenu);
		g.fillRect(0, 0, WIDTH, HEIGHT); // canvas 填充白色
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		// 鼠标移动 监听
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (prex>0 && prey>0) {
					g.setColor(color);
					g.drawLine(prex, prey, e.getX(), e.getY());//上一次鼠标拖动事件点  到本次鼠标事件点 划线
				}
				prex = e.getX();
				prey = e.getY();
				canvas.repaint();
			}
		});
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) { //释放鼠标
					popupMenu.show(canvas, prex, prey);//?弹出菜单显示在什么控件 以及 位置
				}
				prex = -1;
				prey = -1;
			}
		});
		
		f.add(canvas);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BufferedImageTest().init();
	}
	
	class DrawCanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}
		
	}
}
