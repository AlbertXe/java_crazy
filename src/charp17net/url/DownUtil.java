package charp17net.url;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @ClassName: DownUtil
 * @Description:多线程下载
 * @author: 谢洪伟
 * @date: 2018年12月24日 下午2:24:30
 */
public class DownUtil {
	// 1 资源路径 2. 保存路径 3. 线程数 4. 线程数组 5.文件大小
	private String path;
	private String savePath;
	private int threadNum;
	private DownThread[] threads;
	private int fileSize;

	public DownUtil(String path, String savePath, int threadNum) {
		this.path = path;
		this.savePath = savePath;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
	}

	public void download() {
		// 1.url conn 2.conn属性设置 超时 请求方式 属性 3.文件大小 分布下载任务
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Charset", "utf-8");
			conn.setRequestProperty("Accept-Language", "zh-CN");
			conn.setRequestProperty("Connection", "Keep-Alive");
			int fileSize = conn.getContentLength();
			conn.disconnect(); // 关闭连接
			int currentFile = fileSize / threadNum + 1; // 分块文件大小
			for (int i = 0; i < threads.length; i++) {
				// 1.每个线程下载位置 2.下载
				int startPos = i * currentFile;
				RandomAccessFile randomAccessFile = new RandomAccessFile(savePath, "rw");
				randomAccessFile.seek(startPos);

				threads[i] = new DownThread(startPos, currentFile, randomAccessFile);
				threads[i].start();
			}

			for (int i = 0; i < threads.length; i++) {

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public double getComplete() {
		int sum = 0;
		for (int i = 0; i < threads.length; i++) {
			sum += threads[i].length;
		}
		return (sum * 1.0 / fileSize);
	}

	private class DownThread extends Thread {
		// 1 开始位置 2.下载大小 3. 具体文件 4. 进度
		private int startPos;
		private int size;
		private RandomAccessFile file;
		public int length;

		public DownThread(int startPos, int size, RandomAccessFile file) {
			this.startPos = startPos;
			this.size = size;
			this.file = file;
		}

		@Override
		public void run() {
			// 1.url conn 2.conn 属性设置： 超时 方式 请求属性 3.读取文件并下载
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "*/*");
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "utf-8");

				InputStream inputStream = conn.getInputStream();

				inputStream.skip(startPos); // 跳过
				byte[] bs = new byte[1024];
				int len = 0;
				while (length < size && (len = inputStream.read(bs)) != -1) {
					file.write(bs, 0, len);
					length += len;
				}
				file.close();
				inputStream.close();

			} catch (MalformedURLException e) {
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}


