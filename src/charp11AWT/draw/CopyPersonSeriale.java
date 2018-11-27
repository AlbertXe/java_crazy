package charp11AWT.draw;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * 
 * @ClassName:  CopyPersonSeriale   
 * @Description:
 * @author: 谢洪伟 
 * @date:   2018年10月17日 下午3:16:45
 */
public class CopyPersonSeriale {
	Frame f = new Frame();
	Button copy = new Button("copy");
	Button paste = new Button("paste");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea area = new TextArea(5,30);
	Clipboard clipboard = new Clipboard("cb");
	
	public void init(){
		Panel p = new Panel();
		p.add(new Label("name:"));
		p.add(name);
		p.add(new Label("age:"));
		p.add(age);
		f.add(p,BorderLayout.NORTH);
		f.add(area);
		Panel p2  = new Panel();
		copy.addActionListener(e -> copy());
		paste.addActionListener(e -> {
			read();
		});
		
		p2.add(copy);
		p2.add(paste);
		f.add(p2, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}

	private void read() {
		try {
			DataFlavor flavor = new DataFlavor(DataFlavor.javaSerializedObjectMimeType+";class="+Person.class.getName());
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				Person person = (Person) clipboard.getData(flavor);
				area.append(person.toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private void copy() {
		Person person = new Person(name.getText(), age.getText());
		clipboard.setContents(new SerialSelection(person), null);// 封装
	}
	
	
	public static void main(String[] args) {
		new CopyPersonSeriale().init();
	}
}
