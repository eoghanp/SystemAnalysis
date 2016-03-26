package route;

import java.util.ArrayList;
import java.util.List;

import UI.Job;
import Vehicle.Vehicle;
import Works.Order;
import data.Parcel;

public class Route {

	//the route id of the the route
	private int routeId;
	private String routeDetails; //the details of the destinations
	private Vehicle vehicle;
	private int distance;
	private List<Job> jobs = new ArrayList<Job>();
	
	public Route(int routeId, String routeDetails) {
		this.routeId = routeId;
		this.routeDetails = routeDetails;
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
	
	public void assignVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
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
}
