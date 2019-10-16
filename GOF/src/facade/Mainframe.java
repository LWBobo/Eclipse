package facade;

import java.awt.Menu;

public class Mainframe {
	CPU cpu = new CPU();
	Memory memory = new Memory();
	OS os = new OS();
	HardDisk harddisk = new HardDisk();
	
	public void on() {
		cpu.run();
		memory.check();
		harddisk.read();
		os.load();
		System.out.println("系统已经启动");
	}
	
	public void off() {
		System.out.println("系统已经关闭");
	}

}
