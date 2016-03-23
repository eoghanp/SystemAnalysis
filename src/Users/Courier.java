package Users;

public class Courier extends Person {
	private int courierID;
	//public Vehicle courierVehicle;
	//public Order [] OrderList;
	
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
	

	//public void removeJob(Order jobName){
		
//	}

	/*public void removeJob(Order jobName){
		
	}*/

	public void organizeSchedule(){
		
	}

}
