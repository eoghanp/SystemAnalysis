package Works;

import java.util.ArrayList;
import java.util.List;

import UI.Job;
import data.Parcel;

public class Order implements Job{
	
	int OrderID;
	List<Parcel> parcels = new ArrayList<Parcel>();
	//Courier courierDetails;
	//Receipient receipientDetails;
	int priority;
	double price;
	boolean paid;
	int status;
	//enum status {withCustomer, withCourier, delivered};
	
	public Order(List<Parcel> parcels, /*Receipient receipient,*/ double price){
		this.parcels = parcels;
		//this.receipientDetails = receipient;
		this.priority = 3;
		this.status = 0;
		this.price = price;
	}
	
	public Order(List<Parcel> parcels, /*Receipient receipient,*/ double price, int priority){
		this.parcels = parcels;
		//this.receipientDetails = receipient;
		this.priority = priority;
		this.status = 0;
		this.price = price;
	}
	
	public void addParcel(Parcel p){
		parcels.add(p);
	}
	
	public void removeParcel(Parcel p){
		parcels.remove(p);
	}
	
	/*public void setCourier(Courier c){
		this.courierDetails = c;
	}*/
	
	/*public void setReceipient(Receipient r){
		this.receipientDetails = r;
	}*/
	
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
	
	public List<Parcel> getParcels(){
		return parcels;
	}
	
	/*public Courier getCourier(){
		return this.Courier;
	}*/
	
	/*public Receipient getReceipient(){
		return this.receipientDetails;
	}*/
	
	public int getID(){
		return this.OrderID;
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
