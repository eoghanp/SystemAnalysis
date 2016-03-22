package route;

public class Route {

	//the route id of the the route
	private int routeId;
	private String routeDetails; //the details of the destinations
	
	
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
	
	
	
	
}
