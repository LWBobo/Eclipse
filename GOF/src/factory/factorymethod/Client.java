package factory.factorymethod;

public class Client {
	public static void main(String[] args) {
		Television tel =  new HaierTVfactory().createTV();
		AirConditioner airc = new HaierAirConfactory().createAirCon();
		Refrigeratory rf = new HaierRefrifactory().createRefri();
		
		tel.play();
		airc.run();
		rf.run();
		
		
		 tel =  new TCLTVfactory().createTV();
		 airc = new TCLAirConfactory().createAirCon();
		 rf = new TCLRefrifactory().createRefri();
		
		tel.play();
		airc.run();
		rf.run();
		
		tel =  new HisenseTVfactory().createTV();
		 airc = new HisenseAirConfactory().createAirCon();
		 rf = new HisenseRefrifactory().createRefri();
		
		tel.play();
		airc.run();
		rf.run();
		
		
	}
	
	
	
	
	
	

}
