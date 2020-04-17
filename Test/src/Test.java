import java.util.ArrayList;

import java.io.File;
public class Test {

	
	public static Test t1 = new Test();
	public static Test t2 = new Test();
	
	{
		System.out.println("非静态代码块！");
	}
	
	static {
		System.out.println("静态代码块！");
	}
	
	
	public static void main(String []args) {
		new Test();
		new Test();
		
		
	}


}
