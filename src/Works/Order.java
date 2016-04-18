package Works;

import java.util.ArrayList;
import java.util.List;

import Report.Report;
import Users.Recipient;
import parcel.Parcel;

public class Order implements Job{
	
	int OrderID;
	List<Parcel> parcels = new ArrayList<Parcel>();
	//Courier courierDetails;
	Recipient recipientDetails;
	int priority;
	double price;
	boolean paid;
	int status;
	Report report;
	//enum status {withCustomer, withCourier, delivered};
	
	public Order(List<Parcel> parcels, Recipient recipient, double price){
		this.parcels = parcels;
		this.recipientDetails = recipient;
		this.priority = 3;
		this.status = 0;
		this.price = price;
		this.report = new Report(this);
	}
	
	public Order(List<Parcel> parcels, Recipient recipient, double price, int priority){
		this.parcels = parcels;
		this.recipientDetails = recipient;
		this.priority = priority;
		this.status = 0;
		this.price = price;
		this.report = new Report(this);
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
	
	public void setRecipient(Recipient r){
		this.recipientDetails = r;
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
	
	public List<Parcel> getParcels(){
		return parcels;
	}
	
	/*public Courier getCourier(){
		return this.Courier;
	}*/
	
	public Recipient getRecipient(){
		return this.recipientDetails;
	}
	
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
	
	public void setReport(Report r){
		this.report = r;
	}
	
	public Report getReport(){
		return this.report;
	}
	
}
