package factory.factorymethod;

public class HaierTVfactory implements TVFactory {

	@Override
	public Television createTV() {
		
		return new HaierTV();
	}

}
