package command;

import java.io.IOException;
import java.util.Properties;

public class Client {

	public static void main(String[] args) {
		
		Properties pro = new Properties();
		
		Command command = null;
		
		
		try {
			
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("command/butfuncconfig.properies"));
			Class cls = Class.forName(pro.getProperty("package") + "."+ pro.getProperty(pro.getProperty("functionname")));
			command = (Command) cls.newInstance();
		} catch (Exception e) {
			System.out.println("打开配置文件失败");
			e.printStackTrace();
		}

		
		Button button1 = new FunctionButton(command);
		button1.dofunction();
		
		
		
		
	}

}
