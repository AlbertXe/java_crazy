package charp11AWT.menu;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

public class SimpleMenu {
	Frame f = new Frame();
	MenuBar menuBar = new MenuBar();
	Menu file = new Menu("file");
	Menu edit = new Menu("edit");
	
	MenuItem newItem = new MenuItem("create");
	MenuItem saveItem = new MenuItem("save");
	MenuItem exitItem = new MenuItem("exit",new MenuShortcut(KeyEvent.VK_X));// ctrl+X 退出
	
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("copy");
	MenuItem pasteItem = new MenuItem("paste");
	Menu format = new Menu("format");
	MenuItem commentItem = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_SLASH,true));// ctrl + shift + /
	MenuItem cancleItem = new MenuItem("取消注释");
	
	TextArea textArea = new TextArea(6,40);
	
	public void init(){
		ActionListener listener = e -> {
			System.out.println("单击"+e.getActionCommand());
			if (e.getActionCommand().equals("exit")) {
				System.exit(0);
			}
		};
		exitItem.addActionListener(listener);
		commentItem.addActionListener(listener);
		
		//为菜单添加
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		
		//为edit 添加
		edit.add(copyItem);
		edit.add(pasteItem);
		edit.addSeparator();//分割线
		edit.add(autoWrap);
		
		//为 format 菜单添加 
		format.add(commentItem);
		format.add(cancleItem);
		
		edit.add(new MenuItem("-"));
		edit.add(format);//将format  整合到edit
		
		menuBar .add(file);
		menuBar.add(edit);
		f.setMenuBar(menuBar);
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.add(textArea);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new SimpleMenu().init();
	}
}
