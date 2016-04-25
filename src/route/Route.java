package route;

import java.util.ArrayList;
import java.util.List;

//import UI.Route;
import Vehicle.Vehicle;
import Works.Job;
import Works.Order;
import parcel.Parcel;

interface Observer{
	public void update(String location);
}

public class Route implements Observer{
	
	//the route id of the the route
	private int routeId;
	private String routeDetails; //the details of the destinations
	private Vehicle vehicle;
	private int distance;
	private List<Job> jobs = new ArrayList<Job>();
	
	public Route(int routeId, String routeDetails) {
		this.routeId = routeId;
		this.routeDetails = routeDetails;
		System.out.println("Route created");
	}
	
	public Route(int routeId, String routeDetails, int distance, List<Job> jobs) {
		this.routeId = routeId;
		this.routeDetails = routeDetails;
		this.distance = distance;
		this.jobs = jobs;
		System.out.println("Route created");
	}

	public int getRouteId() {
		return routeId;
	}

	public String getRouteDetails() {
		return routeDetails;
	}

	public void setRouteDetails(String routeDetails) {
		this.routeDetails = routeDetails;
	};
	
	public void assignVehicle(Vehicle vehicle2){
		this.vehicle = vehicle2;
	}
	
	public Vehicle getVehicle(){
		return this.vehicle;
	}
	
	public void addJob(Job job){
		this.jobs.add(job);
	}
	
	public List<Job> getJobs(){
		return this.jobs;
	}
	
	public void setDistance(int dist){
		this.distance = dist;
	}
	
	public int getDistance(){
		return this.distance;
	}
	
	@Override
	public void update(String location){
		System.out.println("Route: location is now: " + location);
	}
}
