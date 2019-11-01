package strategy;

public class Client {
/**
 * 策略模式
 * @param args
 */
	public static void main(String[] args) {
			Encrypt e = new KaiSaEncrypt();
			Encrypt e1 = new DESEncrypt();
			User user = new User("张三", "123456");
			user.setE(e1);
			user.encryptpwd();
	}

}
