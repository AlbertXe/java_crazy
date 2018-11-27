package charp11AWT.menu;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.BufferCapabilities;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.BufferCapabilities.FlipContents;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.PaintEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ColorModel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.VolatileImage;
import java.awt.peer.ComponentPeer;
import java.awt.peer.ContainerPeer;
import java.awt.peer.WindowPeer;
import java.nio.charset.Charset;


/**
 * 
 * @ClassName:  PopupMenuTest   
 * @Description:右击菜单
 * @author: 谢洪伟 
 * @date:   2018年9月30日 上午9:39:14
 */
public class PopupMenuTest {
	TextArea textArea = new TextArea(6,50);
	Frame f = new Frame();
	PopupMenu popupMenu = new PopupMenu();
	CheckboxMenuItem auto = new CheckboxMenuItem("自动换行");
	MenuItem copy = new MenuItem(new String("复制".getBytes(), Charset.forName("GB18030")));
	MenuItem paste = new MenuItem("paste");
	Menu format = new Menu("formate");
	MenuItem comment = new MenuItem("注释",new MenuShortcut(KeyEvent.VK_SLASH));
	MenuItem cancle = new MenuItem("取消注释");
	
	public void init(){
		ActionListener listener = e -> {
			String cmd = e.getActionCommand();
			System.out.println(cmd);
			if ("退出".equals(cmd)) {
				System.exit(0);
			}
		};
		comment.addActionListener(listener);// 注释添加事件
		
		popupMenu.add(auto);
		popupMenu.add(copy);
		popupMenu.add(paste);
		
		format.add(comment);
		format.add(cancle);
		popupMenu.add(format);
		
		Panel p = new Panel();
		p.setPreferredSize(new Dimension(300, 160));//?
		p.add(popupMenu);
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {// 如果释放鼠标 右键
					popupMenu.show(p, e.getX(), e.getY());
				}
			}
		});
		f.add(p);
		f.add(textArea,BorderLayout.NORTH);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
		f.pack();
		
	}
	
	public static void main(String[] args) {
		new PopupMenuTest().init();
	}
}
