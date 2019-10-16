package factory.factorymethod;

public class HisenseAirConfactory implements AirConFactory {

	@Override
	public AirConditioner createAirCon() {
		return new HisenseAirCon();
	}

}
