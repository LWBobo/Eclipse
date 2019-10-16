package factory.factorymethod;

public class HaierRefrifactory implements RefriFactory {

	@Override
	public Refrigeratory createRefri() {
		return new HaierRefri();
	}

}
