package charp17net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {

	/**
	 * GET
	 */
	public static String doGet(String url, String param) throws IOException {
		// 1.url 2.conn 3. conn属性 4.连接 5. 读取流
		String result = "";
		String urlName = url + "?" + param;
		URL realUrl = new URL(urlName);
		HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5,1; SV1)");

		conn.connect(); // 建立实际的连接
		Map<String, List<String>> fields = conn.getHeaderFields();
		for (String key : fields.keySet()) {
			System.out.println(key + "=>" + fields.get(key));
		}
		// bufferReader 读取 url 响应
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			result += "\n" + line;
		}
		return result;
	}

	public static String doPost(String url, String param) throws IOException {
		// 1.url 2.conn 3.属性设置 4.dooutput 5.输出流写入参数 6.inputStream获取响应
		String result = "";
		URL realUrl = new URL(url);
		URLConnection conn = realUrl.openConnection();
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");
		conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5,1; SV1)");

		// post 必须设置
		conn.setDoOutput(true);
		conn.setDoInput(true);

		PrintWriter out = new PrintWriter(conn.getOutputStream());
		out.write(param);
		out.flush();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		String line;
		while ((line = reader.readLine()) != null) {
			result += line;
		}

		return result;

	}
}
