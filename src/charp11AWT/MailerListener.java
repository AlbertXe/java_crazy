package charp11AWT;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @ClassName:  MailerListener   
 * @Description: 外部类 监听器 实现   ，一般都是内部类， 内部类好处：1.内聚 2. 更好访问我外部类GUI组件
 * 				外部类原因： 多个GUI 界面共享
 * @author: 谢洪伟 
 * @date:   2018年9月29日 下午4:03:37
 */
public class MailerListener implements ActionListener {
	private TextField address;
	public MailerListener(){}
	
	public MailerListener(TextField address){
		this.address  = address ;
	}
	
	public void setAddress(TextField address) {
		this.address = address;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("发送邮件："+address.getText());
	}

}
