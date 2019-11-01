package observer;

public class Player implements Observer{
	
	String name ;
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void action() {
		System.out.println(getName() + " :冲啊!!!冲啊!!!");
		
	}
}
