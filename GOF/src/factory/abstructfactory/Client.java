package factory.abstructfactory;

public class Client {

	public static void main(String[] args) {
			Television tv;
	        AirConditioner airConditioner;
	        EFactory factory = new HaierFactory();

	        tv = factory.produceTelevision();
	        airConditioner = factory.produceAirConditioner();

	        tv.play();
	        airConditioner.changeTemperature();
	        
	        System.out.println("*********************");
	        
	        factory = new TCLFactory();
	        tv = factory.produceTelevision();
	        airConditioner = factory.produceAirConditioner();

	        tv.play();
	        airConditioner.changeTemperature();
	}

}
