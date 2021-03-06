package Users;

import java.io.IOException;
import java.util.List;

import Works.Order;
import dataIO.DBHandler;
import parcel.Parcel;

public class PersonCustomer extends Person implements Customer
{
	private int customerID;
	private int creditCardNumber;

	public PersonCustomer(String first, String last, String mail, String pass, String add, String phone, int customerID, int creditCardNumber)
	{
		super(first, last, mail, pass, add, phone);
		this.customerID = customerID;
		this.creditCardNumber = creditCardNumber;
	}

	public PersonCustomer(String userName, String passText) {
		super(null, null, userName, passText, null, null);
		DBHandler db = DBHandler.getSingletonInstance();
		int max = 0;
		try {
			List<PersonCustomer> c = db.getCustomer();
			for(int i = 0; i < c.size(); i++)
				if(c.get(i).getCustomerID() > max)
					max = c.get(i).getCustomerID();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.customerID = max+1;
		this.creditCardNumber = 123884962;
	}

	public void provideFeeback()
	{
		
	}

	public int getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}

	@Override
	public int getCardNumber()
	{
		return creditCardNumber;
	}

	public void setCardNumber(int creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void purchaseService(List<Parcel> parcels, double cost, int priority, Manager man, Person person, String addr)
	{
		Order order = new Order(parcels, person, cost, priority, addr);
		DBHandler db = DBHandler.getSingletonInstance();
		db.saveOrder(order);
		man.addOrder(order);
		System.out.print("Purchasing Service: " + order.getPriority() + "\n" + order.getPrice());
	}

	@Override
	public String specifyDetails()
	{
		String customerDetails = customerID + "\n" +
								 creditCardNumber;
		return customerDetails;
	}

}