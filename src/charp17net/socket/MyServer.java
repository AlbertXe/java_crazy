package charp17net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {

	public static List<Socket> sockets = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(3333);

		while (true) {
			Socket socket = serverSocket.accept(); // 阻塞
			System.out.println(socket.getPort());
			sockets.add(socket);

			new Thread(new ServerThread(socket)).start();
		}

	}
}

class ServerThread implements Runnable {
	private Socket socket;
	private BufferedReader reader;

	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String line;
		try {
			while ((line = reader.readLine()) != null) { // 发送给所有的 客户端 聊天群
				for (Socket s : MyServer.sockets) {
					PrintStream out = new PrintStream(s.getOutputStream()); // PrintWtite客户端就收不到？WHY
					out.println(line);
				}
			}
		} catch (IOException e) {
			MyServer.sockets.remove(socket); // 出现异常 移除这个客户端。
			e.printStackTrace();
		}
	}

}
