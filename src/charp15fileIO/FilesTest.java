package charp15fileIO;

import java.io.FileOutputStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: FilesTest
 * @Description:工具类Files 复制 隐藏 读取 大小 写出 Stream递归目录和文件 盘符空间
 * @author: 谢洪伟
 * @date: 2018年12月21日 上午10:06:15
 */
public class FilesTest {
	public static void main(String[] args) throws Exception {
		String root = "src/charp15fileIO/FilesTest.java";
		Files.copy(Paths.get(root), new FileOutputStream("ab.txt"));// ?

		boolean hidden = Files.isHidden(Paths.get(root));
		System.out.println(hidden);

		List<String> lines = Files.readAllLines(Paths.get(root));
		System.out.println(lines);

		System.out.println(Files.size(Paths.get(root)));

		List<String> list = new ArrayList<>();
		list.add("xie");
		list.add("hong");
		Files.write(Paths.get("abc.txt"), list);

		Files.list(Paths.get("src/charp15fileIO")).forEach((dir) -> {
			System.out.println(dir);
		});
		
		Files.lines(Paths.get(root)).forEach(line -> System.out.println(line));

		FileStore fileStore = Files.getFileStore(Paths.get(root));
		System.out.println(fileStore.getTotalSpace());
		System.out.println(fileStore.getUsableSpace());

	}
}
