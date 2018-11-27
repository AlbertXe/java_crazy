package charp15fileIO;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @ClassName:  FileTest   
 * @Description:
 * @author: 谢洪伟 
 * @date:   2018年11月12日 下午3:00:27
 */
public class FileTest {
	public static void main(String[] args) throws Exception {
		
		File file = new File("."); //当前路径 创建 .
		System.out.println(file.getName());// 文件名 或最底 文件夹
		System.out.println(file.getParentFile());//可能null
		System.out.println(file.getAbsoluteFile());// 绝对
		System.out.println(file.getAbsoluteFile().getParentFile());
		
		File tempFile = file.createTempFile("aaa", ".txt",file);// 当前路径创建一个临时文件
		tempFile.deleteOnExit();// jvm退出删除
		
		String[] files = file.list(); //当前路径下所有 文件和目录
		
		File[] roots = File.listRoots();
		for (File root:roots ){
			System.out.println(root);
		}
	}
}
