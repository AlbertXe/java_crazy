package charp12Swing;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 * 
 * @ClassName:  JToolBarTest   
 * @Description: 工具条 测试
 * @author: 谢洪伟 
 * @date:   2018年10月18日 下午2:54:45
 */
public class JToolBarTest {
	JFrame jf = new JFrame("工具条测试");
	JTextArea textArea = new JTextArea(10,20);
	JToolBar toolBar = new JToolBar();
	
	JMenuBar menuBar = new JMenuBar();
	JMenu edit = new JMenu("编辑");
	
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();		
	
	
	Action pasteAction = new AbstractAction("粘贴") {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				try {
					String data = (String) clipboard.getData(DataFlavor.stringFlavor);
					textArea.replaceRange(data, textArea.getSelectionStart(), textArea.getSelectionEnd());
					
				} catch (UnsupportedFlavorException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
	};
	Action copyAction = new AbstractAction("复制") {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			StringSelection contents = new StringSelection(textArea.getText());
			clipboard.setContents(contents, null);
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				pasteAction.setEnabled(true);
			}
		}
	};
	
	public void init(){
		pasteAction.setEnabled(false);
		jf.add(new JScrollPane(textArea)); // 用 滚动条包裹
		JButton copy = new JButton(copyAction); // 会自动转换
		JButton paste = new JButton(pasteAction);
		
		JPanel jPanel = new JPanel();
		jPanel.add(copy);
		jPanel.add(paste);
		jf.add(jPanel,BorderLayout.SOUTH);
		
		toolBar.add(copyAction);
		toolBar.addSeparator();
		toolBar.add(pasteAction);
		
		edit.add(copyAction);
		edit.add(pasteAction);
		menuBar.add(edit);
		jf.setJMenuBar(menuBar);
		
		toolBar.setMargin(new Insets(20, 10, 5, 30));
		jf.add(toolBar, BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.pack();
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new JToolBarTest().init();
	}
}
