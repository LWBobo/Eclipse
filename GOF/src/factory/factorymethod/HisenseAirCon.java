package factory.factorymethod;

public class HisenseAirCon implements AirConditioner {

	@Override
	public void run() {
		System.out.println("海信空调正在运转!");
	}

}
