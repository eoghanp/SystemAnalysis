package Users;

import java.util.ArrayList;
import java.util.List;

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

}
