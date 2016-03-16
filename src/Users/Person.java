package Users;
import javax.swing.*;

public class Person{
	protected String FirstName;
	protected String LastName;
	protected String email;
	private String password;
	protected String address; 
	protected String telephone;
	
	//Git Test----------------
	
	/*public void logIn(email, password){
		//Enter email and password into dialog box
	}
	public void logOut(){
		//Click log out button
	}*/
	
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
	
	public void setEmail(String newEmail){
		email = newEmail;
	}
	
	public void setPassword(String newPassword){
		password = newPassword;
	}
	
	public void setTelephone(String newTelephone){
		telephone = newTelephone;
	}
	
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
	
}