package Users;

public class Courier extends Person{
	private int courierID;
	//public Vehicle courierVehicle;
	//public Order [] OrderList;
	
	public Courier() {
		super(null, null, null, null, null, null);
		this.courierID = 0;
	}


	public int getCourierID() {
		return courierID;
	}

	public void setCourierID(int courierID) {
		this.courierID = courierID;
	}
	
	/*public Order [] getOrderList(){
		return orderList;
	}
	
	public Vehicle getVehicle(){
		return courierVehicle;
	}*/
	
	public String getName(){
		return super.getName();
	}
	
	public void assignJob(){
		
	}
	
	/*public void removeJob(Order jobName){
		
	}*/
	
	public void organizeSchedule(){
		
	}

}
