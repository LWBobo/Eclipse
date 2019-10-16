package factory.factorymethod;

public class TCLAirConfactory implements AirConFactory {

	@Override
	public AirConditioner createAirCon() {
		return new TCLAirCon();
	}

}
