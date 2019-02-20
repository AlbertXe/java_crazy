package charp16thread.test.demo2;

/**
 * 
 * @ClassName: Garage
 * @Description:车库
 * @author: 谢洪伟
 * @date: 2018年12月24日 上午10:57:25
 */

public class Garage {
	private boolean[] flags;

	private boolean isOK = false;

	public Garage(boolean[] flags) {
		this.flags = flags;
	}

	public synchronized void in() {
		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				isOK = true;
				System.out.println("XXX 停车成功");
				flags[i] = false;
				break;
			}
		}

	}
}
