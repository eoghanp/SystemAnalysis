package Works;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Report.Report;
import Users.Recipient;
import dataIO.DBHandler;
import parcel.Parcel;

public class Order implements Job{
	
	private int OrderID;
	private List<Parcel> parcels = new ArrayList<Parcel>();
	private Recipient recipientDetails;
	private int priority;
	private double price;
	private boolean paid;
	private Report report;
	private String collectionAddress;
	public enum Status {withCustomer, withCourier, delivered, notDelivered};
	private Status status;
	
	
	public Order(List<Parcel> parcels, Recipient recipient, double price, int priority, String addr){
		this.parcels = parcels;
		this.recipientDetails = recipient;
		this.priority = priority;
		this.status = Status.withCustomer;
		this.price = price;
		this.collectionAddress = addr;
		this.report = new Report(this);
		DBHandler db = DBHandler.getSingletonInstance();
		int max = 0;
		try {
			List<Order> c = db.getOrder();
			for(int i = 0; i < c.size(); i++)
				if(c.get(i).getOrderID() > max)
					max = c.get(i).getOrderID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.OrderID = max+1;
	}
	
	public Order(int id, List<Parcel> parcels, Recipient recipient, double price, int priority, String addr, String status){
		this.parcels = parcels;
		this.recipientDetails = recipient;
		this.priority = priority;
		this.status = Status.valueOf(status);
		this.price = price;
		this.collectionAddress = addr;
		this.report = new Report(this);
		this.OrderID = id;
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
	
	public void setStatus(){
		switch(this.status){
			case withCustomer: 
				this.status = status.withCourier;
				this.getReport().setCustomerSignature("Customer sig");
				break;
			case withCourier: 
				this.status = status.delivered;
				this.getReport().setCourierSignature("Courier sig");
				this.getReport().setRecipientSignature("Recipient sig");
				break;
			case delivered: this.status = status.notDelivered;
				break;
			case notDelivered: this.status = status.delivered;
				break;
		}
	}
	
	public List<Parcel> getParcels(){
		return parcels;
	}
	
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

	public Status getStatus(){
		return this.status;
	}
	
	public void setReport(Report r){
		this.report = r;
	}
	
	public Report getReport(){
		return this.report;
	}
	
	public void setCollectionAddress(String addr){
		this.collectionAddress = addr;
	}
	
	@Override
	public String getCollectionAddress(){
		return this.collectionAddress;
	}

	@Override
	public int getOrderID() {
		// TODO Auto-generated method stub
		return this.OrderID;
	}
	
}
