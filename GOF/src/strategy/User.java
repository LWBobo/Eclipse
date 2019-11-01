package strategy;

public class User {
	private Encrypt e;
	String name;
	String pwd;
	public User(Encrypt e, String name, String pwd) {
		super();
		this.e = e;
		this.name = name;
		this.pwd = pwd;
	}
	public User() {
	}
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public Encrypt getE() {
		return e;
	}
	public void setE(Encrypt e) {
		this.e = e;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	void encryptpwd() {
		e.doencrypt();
	}
	

}
