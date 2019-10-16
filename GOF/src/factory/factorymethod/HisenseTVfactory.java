package factory.factorymethod;

public class HisenseTVfactory implements TVFactory {

	@Override
	public Television createTV() {
		return new HisenseTV();
	}

}
