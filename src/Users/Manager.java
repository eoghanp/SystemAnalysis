package Users;

import java.util.ArrayList;
import java.util.List;

import UI.Job;
import Works.Order;

public class Manager {
	public List<Order> listOfOrders = new ArrayList<Order>();
	protected Courier [] listOfCouriers;
	
	public void reviewOrder(){
		
	}
	
	public void priortizeOrder(){
		
	}
	
	public Courier[] getListOfCouriers(){
		return listOfCouriers;
	}
	
	public List<Order> getListOfOrders(){
		return listOfOrders;
	}

	public void addOrder(Order order) {
		listOfOrders.add(order);
	}

}
