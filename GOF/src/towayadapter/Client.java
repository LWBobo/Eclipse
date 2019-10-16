package towayadapter;

public class Client {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.catlook();
		cat.catchmouse();
		dog.look();
		dog.bark();
		
		System.out.println("*********添加适配器***************");
		
		
		ICat cat1 = new TwowayAdapter(dog);
		cat1.catlook();
		cat1.catchmouse();
		
		
		IDog dog1 = new TwowayAdapter(cat);
		dog1.look();
		dog1.bark();

	}

}
