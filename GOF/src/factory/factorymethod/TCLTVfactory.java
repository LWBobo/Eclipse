package factory.factorymethod;

public class TCLTVfactory implements TVFactory {

	@Override
	public Television createTV() {
		return new TCLTV();
	}

}
