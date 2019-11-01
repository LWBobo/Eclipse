package observer;

import java.util.ArrayList;

public class League implements Subject{

	@Override
	public void nidify() {
		System.out.println("发现有人受伤!!");
		
		for(Observer p : players) {
			p.action();
		}
		
	}
}
