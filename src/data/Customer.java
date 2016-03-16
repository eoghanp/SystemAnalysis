public class Customer
{
	private int customerID;
	private int creditCardNumber;

	public Customer(int customerID, int creditCardNumber)
	{
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

	public void purchaseSerice()
	{

	}

	public void specifyDetails()
	{
		String customerDetails = customerID + "\n" +
								 creditCardNumber;
		return customerDetails;
	}
}