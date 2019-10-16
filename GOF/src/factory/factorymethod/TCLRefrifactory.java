package factory.factorymethod;

public class TCLRefrifactory implements RefriFactory {

	@Override
	public Refrigeratory createRefri() {
		return new TCLRefri();
	}

}
