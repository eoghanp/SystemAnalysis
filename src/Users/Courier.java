package Users;


import java.io.IOException;
import java.util.List;

import dataIO.DBHandler;
import route.Route;

public class Courier extends Person {
	private int courierID;
	private Route route;
	
	public Courier(String first, String last, String mail, String pass, String add, String phone)
	{
		super(first, last, mail, pass, add, phone);
		DBHandler db = DBHandler.getSingletonInstance();
		int max = 0;
		try {
			List<Courier> c = db.getCourier();
			for(int i = 0; i < c.size(); i++)
				if(c.get(i).getCourierID() > max)
					max = c.get(i).getCourierID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.courierID = max+1;
		this.route = null;
	}
	
	public Courier(String first, String last, String mail, String pass, String add, String phone, int id)
	{
		super(first, last, mail, pass, add, phone);
		this.courierID = id;
		this.route = null;
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

	public String getName(){
		return super.getName();
	}
	

	public void getSchedule(){
		DBHandler db = DBHandler.getSingletonInstance();
		this.route = db.getSpecificRoute(this.courierID);
	}
	
	public void setRoute(Route r){
		this.route = r;
	}
	
	public Route getRoute(){
		return this.route;
	}

}
