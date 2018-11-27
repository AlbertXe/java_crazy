package charp15fileIO.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class RandomFileChannelTest {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("src/charp15fileIO/nio/random.txt", "rw");
		FileChannel channel = raf.getChannel(); // 好像只有者一个 管道 读 写
		MappedByteBuffer buffer = channel.map(MapMode.READ_ONLY, 0, raf.length());
		
		channel.position(raf.length());// 将channel 指针移到最后
		channel.write(buffer);
				
		
	}
}
