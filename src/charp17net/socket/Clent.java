package charp17net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clent {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 3333);
		socket.setSoTimeout(10000); // 读取 超时设置 防止一直阻塞
		// 2. 连接超时 设置
		// Socket socket2 = new Socket();
		// socket2.connect(new InetSocketAddress("127.0.0.1",3333), 10000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println("客户端：" + line);
		}
		reader.close();
		socket.close();

	}
}
