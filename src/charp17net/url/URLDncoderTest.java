package charp17net.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDncoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		URLDecoder.decode("", "utf-8"); // 解密

		URLEncoder.encode("", "GBK"); // 加密

	}
}
