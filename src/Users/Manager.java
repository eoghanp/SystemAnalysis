package Users;

public class Manager extends Person{
	//public Order [] listOfOrders;
	protected Courier [] listOfCouriers;
	
	public Manager(String first, String last, String mail, String pass, String add, String phone, Courier []listOfCouriers)
	{
		super(first, last, mail, pass, add, phone);
		this.listOfCouriers = listOfCouriers;
	}
	
	public void reviewOrder(){
		
	}
	
	public void priortizeOrder(){
		
	}
	
	/*public Courier[] getListOfCouriers(){
		return listOfCouriers;
	}
	
	public Order[] getListOfOrders(){
		return listOfOrders;
	}*/

}
