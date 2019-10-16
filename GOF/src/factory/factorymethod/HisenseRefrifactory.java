package factory.factorymethod;

public class HisenseRefrifactory implements RefriFactory {

	@Override
	public Refrigeratory createRefri() {
		return new HisenseRefri();
	}

}
