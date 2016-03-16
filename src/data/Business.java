public class Business
{
	private String name;
	private String address;
	private String email;
	private String businessCard;
	private int telephone;
	private int creditCardNumber;

	public Business(String name, String address, String email,
		String businessCard, int telephone, int creditCardNumber)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.businessCard = businessCard;
		this.telephone = telephone;
		this.creditCardNumber = creditCardNumber;
	}

	public void getBusinessDetails()
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

	public int getCreditCardNumber()
	{
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}

	public void enquireAboutService()
	{

	}

	public void purchaseService()
	{

	}

	public void specifyDetails()
	{

	}

	public void logInBusiness()
	{

	}

	public void logOutBusiness()
	{

	}
}