package charp15fileIO;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 
 * @ClassName: WatchServiceTest
 * @Description:文件监控 1. 监听服务 2. 注册服务 3. 事件发生
 * @author: 谢洪伟
 * @date: 2018年12月21日 上午11:07:22
 */
public class WatchServiceTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Paths.get("D:/").register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
		while (true) {
			WatchKey take = watchService.take();

			for (WatchEvent event : take.pollEvents()) {
				System.out.println(event.context() + "发生了" + event.kind() + "事件"); // a.txt 发生了 delete 事件
			}

			// 重设 watchkey
			boolean reset = take.reset();
			if (!reset) {
				break;
			}
		}

	}
}
