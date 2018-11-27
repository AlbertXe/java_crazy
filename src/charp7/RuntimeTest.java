package charp7;

import java.io.IOException;

public class RuntimeTest {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("处理器数量："+runtime.availableProcessors());
		System.out.println("空闲内存："+runtime.freeMemory()/1024/1024);	//挖过来的空闲内存
		System.out.println("总内存："+runtime.totalMemory()/1024/1024);	//已经挖过来的内存
		System.out.println("可用最大内存："+runtime.maxMemory()/1024/1024); //从系统挖到的最大内存
		
		System.out.println(RuntimeTest.class.getPackage().getName());
	}
}
