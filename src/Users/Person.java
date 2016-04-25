package Users;

public class Person implements Recipient{
	protected String FirstName;
	protected String LastName;
	protected String email;
	protected String password;
	protected String address; 
	protected String telephone;
	
	public Person(String first, String last, String mail, String pass, String add, String phone){
		FirstName = first;
		LastName = last;
		email = mail;
		password = pass;
		address = add;
		telephone = phone;
		System.out.println("Person created");
	}
	
	public String getName(){
		String name = FirstName + " " + LastName;
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getTelephone(){
		return telephone;
	}
	
	public String getPassword(){
		return password;
	}
	
	@Override
	public void setFirstName(String fname){
		FirstName = fname;
	}
	
	@Override
	public void setLastName(String lname){
		LastName = lname;
	}
	
	public void setEmail(String newEmail){
		email = newEmail;
	}
	
	public void setPassword(String newPassword){
		password = newPassword;
	}
	
	@Override
	public void setTelephone(String newTelephone){
		telephone = newTelephone;
	}
	
	@Override
	public void setAddress(String newAddress){
		address = newAddress;
	}
	
	public String showDetails(){
		String details = FirstName + "\n" +
			   LastName + "\n" +
			   email + "\n" +
			   password + "\n" +
			   address + "\n" +
			   telephone;
		return details;
	}

	@Override
	public String trackDelivery() {
		// TODO Auto-generated method stub
		return null;
	}
	
}