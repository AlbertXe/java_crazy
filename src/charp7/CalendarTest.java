package charp7;

import java.util.Calendar;
import static java.util.Calendar.*;

import java.time.Month;

public class CalendarTest {
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		System.out.print(c.get(YEAR));
		System.out.print(c.get(MONTH));
		System.out.print(c.get(DATE));
		System.out.print(c.get(HOUR));
		System.out.print(c.get(MINUTE));
		System.out.print(c.get(SECOND));
		//设置年月日 时分秒
		c.set(2003,10,11,10,9,25);
		
		c.add(YEAR, -1);
		System.out.println(c.getTime());
		
		c.roll(MONTH, -8);
		System.out.println(c.getTime());
		
		c.setLenient(false);//关闭容错性  
	}
}
