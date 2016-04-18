package Vehicle;

public class VehicleFactory {

	String models[] = {"Ford", "Toyota", "Volkswagon"};
	
	public VehicleFactory() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle getVehicle(String type){
		if (type.equalsIgnoreCase("SMALLVAN"))
			return new SmallVan(models[((int)(Math.random() * 3))], 100, null, null, null);
		else if(type.equalsIgnoreCase("LARGEVAN"))
			return new LargeVan(models[((int)(Math.random() * 3))], 100, null, null, null);
		else if(type.equalsIgnoreCase("SMALLLORRY"))
			return new SmallLorry(models[((int)(Math.random() * 3))], 100, null, null, null);
		else if(type.equalsIgnoreCase("LARGELORRY"))
			return new LargeLorry(models[((int)(Math.random() * 3))], 100, null, null, null);
		else
			return null;
	}
}
