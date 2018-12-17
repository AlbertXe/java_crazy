package charp15fileIO.filelock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 
 * @ClassName:  FileChannelLockTest   
 * @Description:
 * @author: 谢洪伟 
 * @date:   2018年12月12日 下午5:20:08
 */
public class FileChannelLockTest {
	public static void main(String[] args) throws Exception {
		FileChannel channel = new FileOutputStream(new File("d:a.txt")).getChannel();
		
		FileLock fileLock = channel.tryLock();// 非阻塞获得锁，如果已经被锁了就返回 null ; 
//		FileLock lock = channel.lock(); // 阻塞锁。一直等待。
//		FileLock lock = channel.lock(0, 20, true); // 锁定0-20 true 表示共享锁。 不加参数都是排他锁。
		System.out.println(fileLock.isShared());
		Thread.sleep(10000);
		fileLock.release();// 释放锁
		
		
	}
}
