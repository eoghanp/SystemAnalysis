package data;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	int OrderID;
	List<Package> packages = new ArrayList<Package>();
	Courier courierDetails;
	Receipient receipientDetails;
	int priority;
	double price;
	boolean paid;
	int status;
	//enum status {withCustomer, withCourier, delivered};
	
	public Order(){
		
	}
	
	public void addPackage(Package p){
		packages.add(p);
	}
	
	/*public void removePackage(Package p){
		packages.remove(p);
	}*/
	
	public void setCourier(Courier c){
		this.courierDetails = c;
	}
	
	public void setReceipient(Receipient r){
		this.receipientDetails = r;
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
	
	public List<Package> getPackages(){
		return packages;
	}
	
	public Courier getCourier(){
		return this.Courier;
	}
	
	public Receipient getReceipient(){
		return this.receipientDetails;
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
