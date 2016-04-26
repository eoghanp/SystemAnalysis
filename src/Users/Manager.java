package Users;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import Report.SuccessHeader;
import Report.ReportComponent;
import Report.DateFooter;
import Report.FailHeader;
import Report.NameFooter;
import Works.Order;
import dataIO.DBHandler;

public class Manager extends Person{
	private List<Courier> listOfCouriers = new ArrayList<Courier>();
	private List<Order> listOfOrders = new ArrayList<Order>();
	
	public Manager(String first, String last, String mail, String pass, String add, String phone)
	{
		super(first, last, mail, pass, add, phone);
		DBHandler db = DBHandler.getSingletonInstance();
		try {
			listOfCouriers = db.getCourier();
			listOfOrders = db.getOrder();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Courier> getListOfCouriers(){
		return listOfCouriers;
	}
	
	public void addCourier(Courier c){
		listOfCouriers.add(c);
		
		FileWriter aFileWriter = null;
		try {
			aFileWriter = new FileWriter("login.txt", true);
			
			PrintWriter out = new PrintWriter(aFileWriter);
			
			System.out.println("3" + "," + c.getEmail() + 
					 "," + c.getPassword());
				
			out.println("3" + "," + c.getEmail() + 
					 "," + c.getPassword());

			aFileWriter.close();
			out.close();
		} catch (IOException e) {
				
		}
		DBHandler db = DBHandler.getSingletonInstance();
		db.saveCourier(c);
	}
	
	public List<Order> getListOfOrders(){
		return listOfOrders;
	}

	public void addOrder(Order order) {
		listOfOrders.add(order);
	}
	
	public void printReport(Order o) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("printable_Delivery_Report.txt", "UTF-8");
		writer.close();
		ReportComponent myReport;
		myReport = o.getReport();
		myReport = new DateFooter(myReport);
		myReport = new NameFooter(myReport);
		if (o.getReport().getDeliverStatus() == "Not Delivered")
			myReport = new FailHeader(myReport);
		else if (o.getReport().getDeliverStatus() == "Delivery completed and verified by manager")
			myReport = new SuccessHeader(myReport);
		myReport.prtReport();
	}

	public List<Courier> getAvailableCouriers() {
		List<Courier> c = new ArrayList<Courier>();
		for(int i = 0; i < listOfCouriers.size(); i++){
			if(listOfCouriers.get(i).getRoute() == null)
				c.add(listOfCouriers.get(i));
		}
		return c;
	}

}
