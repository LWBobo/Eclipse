package towayadapter;

public class Cat implements ICat {

	@Override
	public void catlook() {
		System.out.println("我是一只猫!");
	}

	@Override
	public void catchmouse() {
		System.out.println("我会抓老鼠!");
	}

}
