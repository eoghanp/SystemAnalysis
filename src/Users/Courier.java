package Users;

import route.Route;

public class Courier extends Person {
	private int courierID;
	//public Vehicle courierVehicle;
	//public Order [] OrderList;
	private Route route;
	
	public Courier(String first, String last, String mail, String pass, String add, String phone, int courierID)
	{
		super(first, last, mail, pass, add, phone);
		this.courierID = courierID;
	}


	public int getCourierID() {
		return courierID;
	}

	public void setCourierID(int courierID) {
		this.courierID = courierID;
	}
	
	public String showCourierDetails(){
		String details = "First Name:   " + super.FirstName +
				"\n\nLast Name:   " + super.LastName +
				"\n\nEmail:   " + super.email +
				"\n\nPassword:   " + super.password +
				"\n\nAddress:   " + super.address +
				"\n\nContact:   " + super.telephone +
				"\n\nCourier ID:   " + courierID;
		return details;
	}
	
	/*public Order [] getOrderList(){
		return orderList;
	}
	
	public Vehicle getVehicle(){
		return courierVehicle;
	}*/
	
	public void assignJob(){
		
	}
	

	public String getName(){
		return super.getName();
	}
	
	/*public void removeJob(Order jobName){
		
	}*/

	public void organizeSchedule(){
		
	}
	
	public void setRoute(Route r){
		this.route = r;
	}
	
	public Route getRoute(){
		return this.route;
	}

}
