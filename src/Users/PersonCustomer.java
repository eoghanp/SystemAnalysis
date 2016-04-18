package Users;

import java.util.List;

import Works.Order;
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
	public void enquireAboutService()
	{
		
	}

	@Override
	public void purchaseService(List<Parcel> parcels, double cost, int priority, Manager man, Person person)
	{
		Order order = new Order(parcels, person, cost, priority);
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