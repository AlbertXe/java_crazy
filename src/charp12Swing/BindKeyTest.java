package charp12Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * 
 * @ClassName:  BindKeyTest   
 * @Description: 键盘绑定   无需  键盘事件
 * @author: 谢洪伟 
 * @date:   2018年10月18日 下午2:29:19
 */
public class BindKeyTest {
	JFrame jf = new JFrame();
	JTextArea textArea = new JTextArea(8,20);
	JButton button = new JButton("发送");
	JTextField textField = new JTextField(10);
	
	
	public void init(){
		jf.add(textArea);
		JPanel jPanel = new JPanel();
		jPanel.add(button);
		jPanel.add(textField);
		jf.add(jPanel,BorderLayout.NORTH);
		
		Action action = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				textArea.append(textField.getText());
				textField.setText("");
			}
		};
		
		button.addActionListener(action);
		
		textField.getInputMap().put(KeyStroke.getKeyStroke('\n',InputEvent.CTRL_MASK), "send");
		textField.getActionMap().put("send", action);
		
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BindKeyTest().init();
	}
}
