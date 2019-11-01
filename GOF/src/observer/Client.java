package observer;

public class Client {

	public static void main(String[] args) {
		Player p1 = new Player("士兵一");
		Player p2 = new Player("士兵二");
		Player p3 = new Player("士兵三");
		Player p4 = new Player("士兵四");
		
		Subject league = new League();
		league.add(p1);
		league.add(p2);
		league.add(p2);
		league.add(p4);
		
		league.nidify();
		
	}

}
