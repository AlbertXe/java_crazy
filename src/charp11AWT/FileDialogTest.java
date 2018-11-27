package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;

/**
 * 
 * @ClassName:  FileDialogTest   
 * @Description:
 * @author: 谢洪伟 
 * @date:   2018年9月29日 下午3:26:25
 */
public class FileDialogTest {
	Frame f = new Frame();
	FileDialog f1 = new FileDialog(f, "f1");
	FileDialog f2 = new FileDialog(f, "f2");
	Button open = new Button("open");
	Button save = new Button("save");
	
	public void init(){
		open.addActionListener(e -> {
			f1.setVisible(true);
			System.out.println(f1.getDirectory()+":"+f1.getFile());
		});
		save.addActionListener(e -> {
			f2.setVisible(true);
			System.out.println(f2.getDirectory()+":"+f2.getFile());
		});
		f.add(open,BorderLayout.NORTH);
		f.add(save);
		f.setVisible(true);
		f.pack();
	}
	
	
	public static void main(String[] args) {
		new FileDialogTest().init();
		
	}
}
