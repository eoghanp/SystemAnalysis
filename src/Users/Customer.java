package Users;

import java.util.List;

import Works.Order;
import data.Parcel;

public class Customer extends Person
{
	private int customerID;
	private int creditCardNumber;

	public Customer(String first, String last, String mail, String pass, String add, String phone, int customerID, int creditCardNumber)
	{
		super(first, last, mail, pass, add, phone);
		this.customerID = customerID;
		this.creditCardNumber = creditCardNumber;
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

	public int getCardNumber()
	{
		return creditCardNumber;
	}

	public void setCardNumber(int creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}

	public void enquireAboutService()
	{
		
	}

	public void purchaseService(List<Parcel> parcels, double cost, int priority, Manager man)
	{
		Order order = new Order(parcels, cost, priority);
		man.addOrder(order);
		System.out.print("Purchasing Service: " + order.getPriority() + "\n" + order.getPrice());
	}

	public String specifyDetails()
	{
		String customerDetails = customerID + "\n" +
								 creditCardNumber;
		return customerDetails;
	}
}