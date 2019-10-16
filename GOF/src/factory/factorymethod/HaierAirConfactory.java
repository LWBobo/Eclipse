package factory.factorymethod;

public class HaierAirConfactory implements AirConFactory {

	@Override
	public AirConditioner createAirCon() {
		return new HaierAirCon();
	}

}
