package charp17net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SimpleAIOServer {
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		// open() bind() accept()
		AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();

		serverSocketChannel.bind(new InetSocketAddress(2222));

		Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();

		AsynchronousSocketChannel socketChannel = future.get();// 阻塞
		socketChannel.write(ByteBuffer.wrap("欢迎来到AIO世界".getBytes())).get();// 无监听器必须get()

	}
}
