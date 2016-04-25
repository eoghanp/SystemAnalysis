package Vehicle;

import java.util.ArrayList;

import route.Route;

public class LargeLorry implements Vehicle, Subject {

	private String model;
	private double maxWeight;
	private double[] storageDimensions;
	private String specialFeatures;
	private String classification;
	private String location;
	//private Route route; //the route assigned to the vehicle
	public ArrayList<Route> observers = new ArrayList<Route>();
	
	public LargeLorry(String model, double maxWeight, double[] storageDimensions, String specialFeatures,
			String classification) {
		this.model = model;
		this.maxWeight = maxWeight;
		this.storageDimensions = storageDimensions;
		this.specialFeatures = specialFeatures;
		this.classification = classification;
		System.out.println("Vehicle created");
	}

	@Override
	public String getLocation(){
		return location;
	}
	
	@Override
	public void setLocation(String l){
		this.location = l;
		notifyObservers();
	}
	
	@Override
	public String getModel() {
		return model;
	}

	@Override
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public double getMaxWeight() {
		return maxWeight;
	}

	@Override
	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public double[] getStorageDimensions() {
		return storageDimensions;
	}

	@Override
	public void setStorageDimensions(double[] storageDimensions) {
		this.storageDimensions = storageDimensions;
	}

	@Override
	public String getSpecialFeatures() {
		return specialFeatures;
	}

	@Override
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public String getClassification() {
		return classification;
	}

	@Override
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	@Override
	public void registerObserver(Route observer){
		observers.add(observer);
	} 
		
	@Override
	public void removeObserver(Route observer){
		observers.remove(observer);
	}
	
	@Override
	public void notifyObservers(){
		for(Route ob : observers){
			System.out.println("Location has changed, notifying observers");
			ob.update(this.location);
		}
	}
}
