package towayadapter;

public class TwowayAdapter implements ICat, IDog {
	ICat cat ;
	IDog dog ;
	
	 public TwowayAdapter(ICat cat) {
		this.cat = cat;
	}
	 public TwowayAdapter(IDog dog) {
		 this.dog = dog;
	 }
	
	@Override
	public void bark() {
		cat.catchmouse();
		
	}


	@Override
	public void catchmouse() {
		dog.bark();
		
	}
	@Override
	public void look() {
		System.out.println("我是一只狗!");
	}
	@Override
	public void catlook() {
		System.out.println("我是一只猫!");
		
	}

}
