package factory.factorymethod;

public class TCLAirCon implements AirConditioner {

	@Override
	public void run() {
		System.out.println("TCL空调正在运转!");
	}

}
