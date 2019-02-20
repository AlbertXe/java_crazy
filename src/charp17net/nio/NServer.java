package charp17net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 
 * @ClassName: NServer
 * @Description: NIO server
 * @author: 谢洪伟
 * @date: 2018年12月25日 下午3:00:11
 */
public class NServer {
	public static void main(String[] args) {
		try {
			new NServer().init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 1.selector 2.port 3. charset
	private Selector selector;
	private final int PORT = 4444;
	private Charset charset = Charset.forName("utf-8");

	public void init() throws IOException {
		// 1.selector 2.ServersocketChannel 3.InetAddress 4. bind 5.blocking 6.
		// registry
		selector = Selector.open(); // 多路复用器
		ServerSocketChannel server = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", PORT);
		server.bind(address);
		server.configureBlocking(false); // 非阻塞
		server.register(selector, SelectionKey.OP_ACCEPT); // 注册 类似
															// server.accept()

		while (selector.select() > 0) {
			for (SelectionKey key : selector.selectedKeys()) {
				// 1.移除正在处理的 2.连接请求 3. 数据读取
				selector.selectedKeys().remove(key);

				if (key.isAcceptable()) {
					// 1.socketChannel 2.configureBlocking 3.registry
					// 4.key对应的channel接受其他请求
					SocketChannel socketChannel = server.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
					key.interestOps(SelectionKey.OP_ACCEPT);
				}
				if (key.isReadable()) {
					// 1.socketChannel 2.byteBuffer 3.数据读取
					// 4.将key对应的channel设置成下一次读取
					SocketChannel socketChannel = (SocketChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					String line = "";
					while (socketChannel.read(buffer) != -1) {
						buffer.flip();
						line += charset.decode(buffer);
					}
					System.out.println("读取的数据：" + line);
					key.interestOps(SelectionKey.OP_READ);

					if (line.length() > 0) {
						for (SelectionKey selectionKey : selector.keys()) {
							// 1.将读取到的内容写入到 每个 socketChannel
							SelectableChannel channel = selectionKey.channel();
							if (channel instanceof SocketChannel) {
								SocketChannel soChannel = (SocketChannel) channel;
								soChannel.write(charset.encode(line));
							}

						}
					}
				}

			}
		}

	}

}
