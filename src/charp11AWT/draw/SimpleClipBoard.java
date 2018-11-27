package charp11AWT.draw;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.Serializable;

import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * 
 * @ClassName:  SimpleClipBoard   
 * @Description:剪贴板     {@link Transferable} 传输对象实现这个接口
 * @author: 谢洪伟 
 * @date:   2018年10月17日 上午11:11:28
 */
public class SimpleClipBoard implements Serializable {
	
	Frame f = new Frame("剪切板");
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();// 系统剪切板
	Clipboard cb = new Clipboard("cb"); // 本地剪切板 是jvm 维护的内存区 
	TextArea t1 = new TextArea(5,20);
	TextArea t2 = new TextArea(5,20);
	
	Button copy = new Button("copy");
	Button paste = new Button("paste");
	
	public void init(){
		Panel p =new Panel();
		p.add(copy);
		p.add(paste);
		copy.addActionListener(e ->{
			StringSelection contents = new StringSelection(t1.getText()); // 封装StringSelection 对象
			clipboard.setContents(contents, null);	// 放入剪贴板
		});
		paste.addActionListener(e ->{
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				try {
					String data = (String) clipboard.getData(DataFlavor.stringFlavor);
					t2.append(data);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(t1);
		box.add(t2);
		f.add(p,BorderLayout.SOUTH);
		f.add(box,BorderLayout.CENTER);
		f.setVisible(true);
		f.pack();
		
	}
	public static void main(String[] args) {
		new SimpleClipBoard().init();
	}
}	
