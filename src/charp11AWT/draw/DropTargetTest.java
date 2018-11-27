package charp11AWT.draw;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * 
 * @ClassName:  DropTargetTest   
 * @Description: 拖放目标 测试   ， 拖放源是默认的
 * @author: 谢洪伟 
 * @date:   2018年10月17日 下午4:02:46
 */
public class DropTargetTest {
	JFrame jf = new JFrame();
	JDesktopPane desktop = new JDesktopPane(); //虚拟桌面
	private int nextX;
	private int nextY;
	
	public void init(){
		desktop.setPreferredSize(new Dimension(500, 500));
		new DropTarget(jf, DnDConstants.ACTION_COPY, new DropTargetListenerTest());// 将jf 窗口当成 拖放窗口  copy 操作 
		
		jf.add(desktop);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.pack();
	}
	
	class DropTargetListenerTest extends DropTargetAdapter{

		@Override
		public void drop(DropTargetDropEvent event) {
			event.acceptDrop(DnDConstants.ACTION_COPY); // 接受 copy
			Transferable transferable = event.getTransferable();  // 数据传输的接口
			DataFlavor[] flavors = transferable.getTransferDataFlavors();  // 取出类型
			for (DataFlavor flavor : flavors) {
				if (flavor.equals(DataFlavor.javaFileListFlavor)) {
					try {
						List files = (List) transferable.getTransferData(flavor);
						for (Object f : files) {
							show((File)f,event); // 显示每个文件
						}
						
					} catch (UnsupportedFlavorException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} //取出数据
				}
				
			}
			
		}

		private void show(File f, DropTargetDropEvent event) {
			try {
				Image iamge = ImageIO.read(f);
				if (iamge == null) {
					event.dropComplete(true); // 结束 拖放  ，停止阻塞 拖放目标。
					JOptionPane.showMessageDialog(desktop, "不支持这种文件");
					return;
				}
				
				ImageIcon icon = new ImageIcon(iamge);
				JInternalFrame iFrame = new JInternalFrame(f.getName(),true, true, true, true); // 内部窗口 显示图片
				JLabel label = new JLabel(icon);
				iFrame.add(new JScrollPane(label));
				desktop.add(iFrame);
				//设置内部窗口 位置  默认 0 0（）
				iFrame.reshape(nextX, nextY, 250, 250);
				iFrame.show();// 显示
				
				nextX += 30;
				nextY += 30;
				if (nextX>250) {
					nextX = 0;
				}
				if (nextY>250) {
					nextY = 0;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new DropTargetTest().init();
	}

}
