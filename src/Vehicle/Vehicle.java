package Vehicle;

import route.Route;
import java.util.ArrayList;

interface Subject{
	public void registerObserver(Route observer);
	public void removeObserver(Route observer);
	public void notifyObservers();
}

public class Vehicle implements Subject{

	private String model;
	private double maxWeight;
	private double[] storageDimensions;
	private String specialFeatures;
	private String classification;
	private String location;
	//private Route route; //the route assigned to the vehicle
	public ArrayList<Route> observers = new ArrayList<Route>();

	
	//constructor
	public Vehicle(String model, double maxWeight, double[] storageDimensions, String specialFeatures,
			String classification) {
		this.model = model;
		this.maxWeight = maxWeight;
		this.storageDimensions = storageDimensions;
		this.specialFeatures = specialFeatures;
		this.classification = classification;
		System.out.println("Vehicle created");
	}

	public String getLocation(){
		return location;
	}
	
	public void setLocation(String l){
		this.location = l;
		notifyObservers();
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
	
	/*public void setRoute(Route route) {
		this.route = route;
	}
	
	public Route getRoute() {
		return route;
	}*/

}
