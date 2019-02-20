package charp15fileIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * @ClassName: FileVisitorTest
 * @Description: 遍历文件和目录 以前是递归
 * @author: 谢洪伟
 * @date: 2018年12月21日 上午10:40:50
 */
public class FileVisitorTest {
	public static void main(String[] args) throws IOException {

		Files.walkFileTree(Paths.get("src", "charp15fileIO"), new FileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问");
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (file.endsWith("PathTest.java")) {

					System.out.println("已经找到");
					return FileVisitResult.TERMINATE;
				}

				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return null;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				return null;
			}

		});
	}
}
