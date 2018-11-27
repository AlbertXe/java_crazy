package charp15fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @ClassName:  InsertContent   
 * @Description:向文件 中插入内容
 * @author: 谢洪伟 
 * @date:   2018年11月21日 下午3:39:09
 */
public class InsertContent {
	public static void insert(String fileName, long pos , String content) throws IOException{
		File tempFile = File.createTempFile("tmp", null); // 临时文件
		tempFile.deleteOnExit(); // jvm 退出 删除
		
		//1. 将插入点之后的数据 保存到 临时文件
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		FileInputStream fis = new FileInputStream(tempFile);
		FileOutputStream fos = new FileOutputStream(tempFile);
		
		raf.seek(pos);
		
		int len = 0;
		byte[] b = new byte[1024];
		while((len = raf.read(b))>0){
			fos.write(b, 0, len);
		}
		
		//2. 将要插入内容插入到 文件
		raf.seek(pos);
		raf.write(content.getBytes());
		//3. 追加临时文件
		while ((len = fis.read(b))>0){
			raf.write(b,0,len);
		}
	}
	
	public static void main(String[] args) {
		try {
			insert("src/charp15fileIO/appender.txt", 17, "这是插入测试");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
