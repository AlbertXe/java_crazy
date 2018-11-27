package charp3;

public class Table99 {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (j<=i) {
					if (j==i) {
						System.out.print(i+"*"+j+"="+i*j);
					}else {
						System.out.print(i+"*"+j+"="+i*j+",");
					}
				}
			}
			System.out.println();
		}
		
	}
}
