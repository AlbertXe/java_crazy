package charp17net.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @ClassName: Server
 * @Description:
 * @author: 谢洪伟
 * @date: 2018年12月25日 上午10:08:09
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(3333);

		while (true) {
			Socket socket = serverSocket.accept(); // 监听请求
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.write("I'm come form Server");
			out.close();
			socket.close();

		}
	}
}
