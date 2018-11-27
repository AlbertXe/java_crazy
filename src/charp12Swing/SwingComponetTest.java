package charp12Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @ClassName:  SwingComponetTest   
 * @Description:	窗口  右键菜单
 * @author: 谢洪伟 
 * @date:   2018年10月18日 上午9:22:47
 */
public class SwingComponetTest {
	JFrame f = new JFrame("测试");
	Icon okIcon = new ImageIcon("icon/a.PNG");
	JButton ok = new JButton("确认", okIcon);
	JRadioButton male = new JRadioButton("男",true);
	JRadioButton female = new JRadioButton("女");
	ButtonGroup bg = new ButtonGroup(); // 组合男女
	JCheckBox married = new JCheckBox("是否已婚？",false);
	
	String[] colors = {"red","green","blue"};
	JComboBox<String> colorCombo = new JComboBox<>(colors); // 下拉框
	JList<String> colorList = new JList<>(colors); // 列表框
	
	JTextArea ta = new JTextArea(8,20);
	JTextField name = new JTextField(15);
	
	JMenuBar mb =new JMenuBar();
	JMenu edit =new JMenu("edit");
	JMenu file = new JMenu("file");
	
	Icon newIcon = new ImageIcon("");
	JMenuItem newItem = new JMenuItem("新建"); // 新建菜单项
	Icon saveIcon = new ImageIcon("");
	JMenuItem saveItem = new JMenuItem("保存");
	Icon exitIcon = new ImageIcon("");
	JMenuItem exitItem = new JMenuItem("退出");
	JCheckBoxMenuItem autowrap = new JCheckBoxMenuItem("自动换行");
	Icon pasteIcon = new ImageIcon("");
	JMenuItem pasteItem = new JMenuItem("粘贴");
	Icon copyIcon = new ImageIcon("");
	JMenuItem copyItem = new JMenuItem("复制");
	
	JMenu format =new JMenu("格式");
	JMenuItem commentItem = new JMenuItem("注释");
	JMenuItem cancleItem = new JMenuItem("取消注释");
	
	JPopupMenu pop = new JPopupMenu(); // 定义一个右键菜单 改风格
	ButtonGroup flavorGroup = new ButtonGroup();
	JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("metal风格", true);
	JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("nimbus风格");
	JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("windows风格");
	JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("classic风格");
	JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("motif风格");
	
	public void init(){
		JPanel bottom = new JPanel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom,BorderLayout.SOUTH);
		
		JPanel checkPanel = new JPanel();
		checkPanel.add(colorCombo);
		bg.add(male);
		bg.add(female);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		Box topLeft = Box.createVerticalBox(); // 垂直排列的 box
		JScrollPane tajsp = new JScrollPane(ta); // 滚动
		topLeft.add(tajsp);
		topLeft.add(checkPanel);
		
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		f.add(top); //将top 放在中间
		
		// ------------下面开始组合菜单---------------
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));// 快捷键
		newItem.addActionListener(e->ta.append("单击le 新建 菜单"));
		
		file.add(newItem); // 为file 菜单添加菜单项
		file.add(exitItem);
		file.add(saveItem);
		
		edit.add(autowrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		
		commentItem.setToolTipText("将代码注释起来");// 为此组件添加提示信息
		format.add(commentItem);
		format.add(cancleItem);
		
		edit.add(new JMenuItem("-")); // 该方式不行
		edit.add(format);  // format 二级菜单
		
		mb.add(file); // 添加到 菜单条中
		mb.add(edit);
		
		f.setJMenuBar(mb);
		
		flavorGroup.add(metalItem); // 组合 一起
		flavorGroup.add(nimbusItem);
		flavorGroup.add(windowsItem);
		flavorGroup.add(classicItem);
		flavorGroup.add(motifItem);
		pop.add(metalItem);
		pop.add(nimbusItem);
		pop.add(windowsItem);
		pop.add(classicItem);
		pop.add(motifItem);
		
		ActionListener listener = e -> {
			try {
				switch (e.getActionCommand()) {
				case "metal风格":
					changeFlavor(1);
					break;
				case "nimbus风格":
					changeFlavor(2);
					break;
				case "windows风格":
					changeFlavor(3);
					break;
				case "classic风格":
					changeFlavor(4);
					break;
				case "motif风格":
					changeFlavor(5);
					break;

				default:
					break;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		};
		
		metalItem.addActionListener(listener); // 添加事件
		nimbusItem.addActionListener(listener);
		windowsItem.addActionListener(listener);
		classicItem.addActionListener(listener);
		motifItem.addActionListener(listener);
		
		ta.setComponentPopupMenu(pop); // 该方法 可设置右键菜单  无需事件
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
		
		
	}
	
			
	private void changeFlavor(int i) throws Exception {
		switch (i) {
		case 1:
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			break;
		case 2:
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			break;
		case 3:
			UIManager.setLookAndFeel("sun.javax.swing.plaf.windows.WindowsMetalLookAndFeel");
			break;
		case 4:
			UIManager.setLookAndFeel("sun.javax.swing.plaf.windows.WindowsClassicLookAndFeel");
			break;
		case 5:
			UIManager.setLookAndFeel("sun.javax.swing.plaf.motif.MotifLookAndFeel");
			break;
		default:
			break;
		}
		SwingUtilities.updateComponentTreeUI(f.getContentPane()); // 窗口内 顶级容器 及其内部所有 组件
		SwingUtilities.updateComponentTreeUI(mb); // 菜单条  以及内部所有组件
		SwingUtilities.updateComponentTreeUI(pop); //更新右键菜单 及其内部
	}


	public static void main(String[] args) {
		new SwingComponetTest().init();
	}
	
}	