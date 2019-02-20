package charp17net.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOServer {
	public static void main(String[] args) {
		AIOServer server = new AIOServer();
		try {
			server.startListen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// port utf-8 channels
	private final int PORT = 1234;
	public final String UTF_8 = "utf-8";
	public static List<AsynchronousSocketChannel> channels = new ArrayList<>();

	public void startListen() throws IOException {
		// 1.线程池 2. channelGroup 3.serverchannel 4.bind 5. accept 带监听
		ExecutorService service = Executors.newFixedThreadPool(20);
		AsynchronousChannelGroup group = AsynchronousChannelGroup.withThreadPool(service);
		AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(group);
		serverSocketChannel.bind(new InetSocketAddress(2222));
		serverSocketChannel.accept(null, new AcceptHandler(serverSocketChannel));
	}
}

class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
	private AsynchronousServerSocketChannel serverSocketChannel;
	private ByteBuffer buffer = ByteBuffer.allocate(1024);

	public AcceptHandler(AsynchronousServerSocketChannel serverSocketChannel) {
		this.serverSocketChannel = serverSocketChannel;
	}

	@Override
	public void completed(AsynchronousSocketChannel asc, Object attachment) {
		// 1.添加新连接 2.准备下次连接
		AIOServer.channels.add(asc);

		serverSocketChannel.accept(null, this);
		asc.read(buffer, null, new CompletionHandler<Integer, Object>() {

			@Override
			public void completed(Integer result, Object attachment) {
				// 将buff 中的内容写到各 channel 中。
				buffer.flip();
				String  content = StandardCharsets.UTF_8.decode(buffer).toString();
				for (AsynchronousSocketChannel channel : AIOServer.channels) {
					try {
						channel.write(ByteBuffer.wrap(content.getBytes("utf-8"))).get();
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
				buffer.clear();
				asc.read(buffer, null, this);// 读取下一次数据
			}

			@Override
			public void failed(Throwable exc, Object attachment) {
				System.out.println("读取数据失败=" + exc);
				AIOServer.channels.remove(serverSocketChannel);
			}
		});
	}

	@Override
	public void failed(Throwable exc, Object attachment) {
		System.out.println("连接失败" + exc);
	}

}

