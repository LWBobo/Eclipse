package factory.abstructfactory;

public class TCLAirConditioner implements AirConditioner{

	@Override
	public void changeTemperature() {
		System.out.println("TCL空调控温中");
		
	}
}
