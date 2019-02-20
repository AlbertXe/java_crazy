package charp15fileIO;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @ClassName: PathTest
 * @Description:路径 深度 根路径 绝对路径 构建路径
 * @author: 谢洪伟
 * @date: 2018年12月21日 上午9:57:28
 */
public class PathTest {
	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println(path);

		int count = path.getNameCount();
		System.out.println(count);

		Path root = path.getRoot(); // 项目的跟路径
		System.out.println(root);

		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);

		Path path2 = Paths.get("d:\\", "a.txt");
		System.out.println(path2);
	}
}
