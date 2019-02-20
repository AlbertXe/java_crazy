package charp17net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 3333);

		new Thread(new ClientThread(socket)).start(); // 不断读取 服务器

		PrintStream out = new PrintStream(socket.getOutputStream()); // 输出到socket

		// 读取键盘

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			out.println(line);
		}

	}
}

class ClientThread implements Runnable {
	private Socket socket;
	private BufferedReader reader;

	public ClientThread(Socket socket) {
		this.socket = socket;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String line;

		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(Thread.currentThread().getName() + ":" + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
