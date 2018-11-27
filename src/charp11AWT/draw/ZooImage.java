package charp11AWT.draw;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @ClassName:  ZooImage   
 * @Description: 比例
 * @author: 谢洪伟 
 * @date:   2018年10月17日 上午10:23:27
 */
public class ZooImage {
	BufferedImage image = new BufferedImage(60, 80, BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	
	public void zoo() throws Exception{
		BufferedImage src = ImageIO.read(new File("E:/workspace/java_crazy/1-3hash.PNG"));
//		RenderedImage renderedImage = src;
		g.drawImage(image, 30, 30, 60, 80, null);
		
		// 原样画图
		ImageIO.write(src,"jpg", new File("E:/workspace/java_crazy/1-5hash.PNG"));
		
		ImageIO.write(image, "jpeg", new File("E:/workspace/java_crazy/1-4hash.PNG"));
		System.out.println(2);
	}
	public static void main(String[] args) {
		try {
			new ZooImage().zoo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
