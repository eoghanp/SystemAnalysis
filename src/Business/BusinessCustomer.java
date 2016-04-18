package Business;

import java.util.List;

import Users.Manager;
import Users.Person;
import Users.Customer;
import Works.Order;
import parcel.Parcel;

public class BusinessCustomer implements Customer
{
	private String name;
	private String address;
	private String email;
	private String businessCard;
	private int telephone;
	private int creditCardNumber;

	public BusinessCustomer(String name, String address, String email,
		String businessCard, int telephone, int creditCardNumber)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.businessCard = businessCard;
		this.telephone = telephone;
		this.creditCardNumber = creditCardNumber;
	}

	public String getBusinessDetails()
	{
		String businessDetails = name + "\n" +
								 address + "\n" +
								 email + "\n" +
								 businessCard + "\n" +
								 telephone + "\n" +
								 creditCardNumber;
		return businessDetails;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getBusinessCard()
	{
		return businessCard;
	}

	public void setBusinessCard(String businessCard)
	{
		this.businessCard = businessCard;
	}

	public int getTelephone()
	{
		return telephone;
	}

	public void setTelephone(int telephone)
	{
		this.telephone = telephone;
	}

	@Override
	public int getCardNumber()
	{
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber)
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
		return null;
	}

	public void logInBusiness()
	{

	}

	public void logOutBusiness()
	{

	}
}