package Vehicle;

import route.Route;

public class Vehicle {

	private String model;
	private double maxWeight;
	private double[] storageDimensions;
	private String specialFeatures;
	private String classification;
	//private Route route; //the route assigned to the vehicle

	
	//constructor
	public Vehicle(String model, double maxWeight, double[] storageDimensions, String specialFeatures,
			String classification) {
		this.model = model;
		this.maxWeight = maxWeight;
		this.storageDimensions = storageDimensions;
		this.specialFeatures = specialFeatures;
		this.classification = classification;
	}

	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public double[] getStorageDimensions() {
		return storageDimensions;
	}

	public void setStorageDimensions(double[] storageDimensions) {
		this.storageDimensions = storageDimensions;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	/*public void setRoute(Route route) {
		this.route = route;
	}
	
	public Route getRoute() {
		return route;
	}*/

}
