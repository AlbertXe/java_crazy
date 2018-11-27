package charp11AWT.draw;

import java.util.Arrays;

import javax.imageio.ImageIO;

/**
 * 
 * @ClassName:  ImageIOTest   
 * @Description:读写 磁盘图片 工具
 * @author: 谢洪伟 
 * @date:   2018年10月17日 上午10:18:40
 */
public class ImageIOTest {
	public static void main(String[] args) {
		String[] names = ImageIO.getReaderFormatNames();
		System.out.println(Arrays.asList(names));
		String[] names2 = ImageIO.getWriterFormatNames();
		System.out.println(Arrays.asList(names2));
	}
}
