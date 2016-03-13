package data;

public class Order {
	
	int OrderID;
	//Package packages[];
	//Courier courierDetails;
	//Receipient receipientDetails;
	int priority;
	double price;
	boolean paid;
	int status;
	//enum status {withCustomer, withCourier, delivered};
	
	public Order(){
		
	}
	
	public void setPriority(int newPriority){
		this.priority = newPriority;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
	
	public void setPaid(boolean newPaid){
		this.paid = newPaid;
	}
	
	public void setStatus(int newStatus){
		this.status = newStatus;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public boolean getPaid(){
		return this.paid;
	}

	public int getStatus(){
		return this.status;
	}
	
}
