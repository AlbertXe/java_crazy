package charp17net.url;

public class Main {
	public static void main(String[] args) {
		DownUtil util = new DownUtil("", "", 4);
		util.download();

		new Thread(() -> {
			while (util.getComplete() < 1) {
				System.out.println("完成：" + util.getComplete());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();

	}
}
