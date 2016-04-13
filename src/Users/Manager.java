package Users;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import Report.SuccessHeader;
import Report.ReportComponent;
import Report.DateFooter;
import Report.FailHeader;
import Report.NameFooter;
import Works.Job;
import Works.Order;

public class Manager extends Person{
	//public Order [] listOfOrders;
	protected List<Courier> listOfCouriers = new ArrayList<Courier>();
	public List<Order> listOfOrders = new ArrayList<Order>();
	
	public Manager(String first, String last, String mail, String pass, String add, String phone)
	{
		super(first, last, mail, pass, add, phone);
	}
	
	public void reviewOrder(){
		
	}
	
	public void priortizeOrder(){
		
	}
	
	public List<Courier> getListOfCouriers(){
		return listOfCouriers;
	}
	
	public void addCourier(Courier c){
		listOfCouriers.add(c);
	}
	
	public List<Order> getListOfOrders(){
		return listOfOrders;
	}

	public void addOrder(Order order) {
		listOfOrders.add(order);
	}
	
	public void printReport(Order o) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("printable_Delivery_Report.txt", "UTF-8");
		//writer.println("The first line");
		//writer.println("The second line");
		writer.close();
		ReportComponent myReport;
		myReport = o.getReport();
		myReport = new DateFooter(myReport);
		myReport = new NameFooter(myReport);
		myReport = new FailHeader(myReport);
		myReport = new SuccessHeader(myReport);
		myReport.prtReport();
	}

}
