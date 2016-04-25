package Vehicle;

public interface Vehicle {

	public String getLocation();
	public void setLocation(String l);
	public String getModel();
	public void setModel(String model);
	public double getMaxWeight();
	public void setMaxWeight(double maxWeight);
	public double[] getStorageDimensions();
	public void setStorageDimensions(double[] storageDimensions);
	public String getSpecialFeatures();
	public void setSpecialFeatures(String specialFeatures);
	public String getClassification();
	public void setClassification(String classification);
	
}
