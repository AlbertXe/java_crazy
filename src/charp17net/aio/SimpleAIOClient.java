package charp17net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SimpleAIOClient {
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		// 1.ByteBuffer 2.open 3.connect 4. read

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 2222)).get(); // 没有监听器就必须get()

		buffer.clear();
		Future<Integer> future = socketChannel.read(buffer);
		future.get(); // 读取数据
		buffer.flip();

		Charset charset = Charset.forName("utf-8");
		System.out.println(charset.decode(buffer));

	}
}
