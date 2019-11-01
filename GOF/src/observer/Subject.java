package observer;

import java.util.ArrayList;

public interface Subject {

	ArrayList<Observer> players = new ArrayList<Observer>();
	
	void nidify();
	
	default void add(Player p) {
		players.add(p);
	}
	
	default void move(Player p) {
		players.remove(p);
	}
	
}
