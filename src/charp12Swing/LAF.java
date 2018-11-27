package charp12Swing;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * 
 * @ClassName:  LAF   
 * @Description: 展示  java本地支持 LookAndFeel 
 * @author: 谢洪伟 
 * @date:   2018年10月17日 下午5:08:25
 */
public class LAF {
	/*Metal
	Nimbus
	CDE/Motif
	Windows
	Windows Classic*/
	public static void main(String[] args) {
		LookAndFeelInfo[] lookAndFeels = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo info : lookAndFeels) {
			System.out.println(info.getName());
		}
	}
}
