package towayadapter;

public class Dog implements IDog {

	@Override
	public void look() {
		System.out.println("我是一只狗!");
	}

	@Override
	public void bark() {
		System.out.println("汪汪汪!!!!");
	}

}
