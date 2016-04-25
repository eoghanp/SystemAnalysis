package Vehicle;

public class LocationUpdater extends Thread{

	private Vehicle vehicle;
	
	public LocationUpdater(Vehicle vehicle) {
		// TODO Auto-generated constructor stub
		this.vehicle = vehicle;
	}

	public void run(){
		String[] locations = {"Limerick", "Offaly", "Clare", "Cork", "Tipperary"};
		while(true){
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vehicle.setLocation(locations[(int)(Math.random()*5)]);
		}
	}
	
}
