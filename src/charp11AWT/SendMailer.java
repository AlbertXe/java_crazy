package charp11AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;

public class SendMailer {
	Frame f = new Frame("Test");
	TextField textField = new TextField(40);
	Button button = new Button("send");
	
	public void init(){
		button.addActionListener(new MailerListener(textField));
		f.add(textField);
		f.add(button,BorderLayout.SOUTH);
		f.setVisible(true);
		f.pack();
		
	}
	
	public static void main(String[] args) {
		new SendMailer().init();
	}
}
