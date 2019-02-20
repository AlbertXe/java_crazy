package charp17net.ip;

import java.io.IOException;
import java.net.InetAddress;

/**
 * 
 * @ClassName: InetAddressTest
 * @Description:实例 是否可达 ip
 * @author: 谢洪伟
 * @date: 2018年12月24日 下午2:02:20
 */
public class InetAddressTest {
	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName("www.baidu.com");
		System.out.println("可达：" + address.isReachable(2000));
		System.out.println("ip=" + address.getHostAddress());
		System.out.println("全限定名=" + address.getCanonicalHostName());
		System.out.println(address);

	}
}
