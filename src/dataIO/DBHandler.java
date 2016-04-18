package dataIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import route.Route;

import Business.BusinessCustomer;
import Users.Courier;
import Users.PersonCustomer;
import Users.Manager;
import Users.Person;
import Users.Recipient;
import Vehicle.SmallVan;
import Vehicle.Vehicle;
import Works.Job;
import Works.Order;
import parcel.Parcel;

public class DBHandler {
	
	public void saveBusiness(BusinessCustomer business)
	{
		String data = "";
		data += business.getAddress() + "|";
		data += business.getBusinessCard() + "|";
		data += business.getBusinessDetails() + "|";
		data += business.getCardNumber() + "|";
		data += business.getEmail() + "|";
		data += business.getName() + "|";
		data += business.getTelephone() + "\n";
		
		try{
    		File file =new File("buisness.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	List<BusinessCustomer> getBusiness() throws IOException
	{
		List<BusinessCustomer> business = new ArrayList<BusinessCustomer>();
		try {
			FileReader fr = new FileReader("buisness.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				String Address;
				String BusinessCard;
				String BusinessDetails;
				int CardNumber;
				int Telephone;
				String Name;
				String Email;
				
				String[] tokens = line.split("|");
				Address = tokens[0];
				BusinessCard = tokens[2];
				BusinessDetails = tokens[3];
				CardNumber=Integer.parseInt(tokens[4]);
				Email=tokens[4];
				Name=tokens[5];
				Telephone=Integer.parseInt(tokens[6]);
				
				BusinessCustomer businesses = new BusinessCustomer(Name, Address, Email, BusinessCard, Telephone, CardNumber);
				business.add(businesses);			
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return business;
	}
	
	public void saveOrder(Order order)
	{
		String data = "";
		data = order.getID() + "|";
		data += order.getPaid() + "|";
		List<Parcel> parcels = order.getParcels();
		String parcelsData="";
		for(int i=0; i<parcels.size(); i++)
		{	
			String description=null!=parcels.get(i).getDescription() ? parcels.get(i).getDescription() : "des";
			int[] dim=parcels.get(i).getDimensions();
			int length=dim[0];
			int width=dim[1];
			int height=dim[2];
			int id=parcels.get(i).getParcelID();
			String requirements = parcels.get(i).getSpecialRequirements();
			int urgent = parcels.get(i).getUrgency();
			double weight = parcels.get(i).getWeight();
			parcelsData += id + "," + description + "," + length + "," +  width + "," +  height + "," +  weight + "," +  urgent + "," +  requirements + "#";
    		
		}
		parcelsData += "|";
		data+=parcelsData;
		data += order.getPrice() + "|";
		data += order.getPriority() + "|";
		Recipient rec = order.getRecipient();
		data+=rec.getAddress() + "%";
		data+=rec.getName() + "%";
		data+=rec.getTelephone() + "%";
		data += order.getStatus() + "\n";
		
		try{
    		File file =new File("order.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	
	List<Order> getOrder() throws IOException
	{
		List<Order> orders = new ArrayList<Order>();
		try {
			FileReader fr = new FileReader("order.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				String[] tokens = line.split("|");
				int id = Integer.parseInt(tokens[0]);
				boolean paid = Boolean.getBoolean(tokens[2]);
				String [] parcels = tokens[3].split("#");
				List<Parcel> parcel = new ArrayList<Parcel>();
				for(int i=0; i<parcels.length; i++)
				{
					String description="";
					int[] dim={0,0,0};
					int length;
					int width;
					int height;
					int idp;
					String requirements;
					int urgent;
					double weight;
					
					String[] tokensp = parcels[i].split(",");
					idp=Integer.parseInt(tokensp[0]);
					description=tokensp[1];
					length=Integer.parseInt(tokensp[2]);
					width=Integer.parseInt(tokensp[3]);
					height=Integer.parseInt(tokensp[4]);
					dim[0]=length;
					dim[1]=width;
					dim[3]=height;
					weight=Double.parseDouble(tokensp[5]);
					urgent=Integer.parseInt(tokensp[6]);
					requirements=tokensp[7];
					
					Parcel parcelp = new Parcel(description, idp, dim, weight, requirements, urgent);
					parcel.add(parcelp);
				}
				Double price = Double.parseDouble(tokens[4]);
				int priority=Integer.parseInt(tokens[5]);
				String tokensr[] = tokens[6].split("%");
				String add =tokensr[0];
				String []name =tokensr[1].split(" ");
				String first = name[0];
				String last = name[1];
				String phone =tokensr[2];
				int status = Integer.parseInt(tokensr[3]);
				
				
				Recipient rec = new Person(first, last, "", "", add, phone);
				Order order = new Order(parcel, rec, priority);
				orders.add(order);			
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return orders;
	}
	
	
	public void saveCourier(Courier courier)
	{
		String data = "";

		data+=courier.getCourierID()+ "|";
		data+=courier.getAddress() + "|";
		data+=courier.getEmail()+ "|";
		data+=courier.getName()+ "|";
		data+=courier.getTelephone()+ "\n";
		
	
		try{ 		
    		File file =new File("courier.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		
	}
	
	List<Courier> getCourier() throws IOException
	{
		List<Courier> couriers = new ArrayList<Courier>();
		try {
			FileReader fr = new FileReader("courier.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				
				String[] tokens = line.split("|");
				int id = Integer.parseInt(tokens[0]);
				String address = tokens[1];
				String email = tokens[2];
				String[] name = tokens[3].split(" ");
				String first = name[0];
				String last = name[1];
				String telephone=tokens[4];
				
				Courier corior = new Courier(first, last, email, "", address, telephone, id);
				couriers.add(corior);			
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return couriers;
	}
	
	public void saveCustomer(PersonCustomer customer)
	{
		String data ="";

		data+=customer.getCustomerID()+ "|";
		data+=customer.getName()+ "|";
		data+=customer.getEmail()+ "|";
		data+=customer.getAddress()+ "|";
		data+=customer.getTelephone()+ "|";
		data+=customer.getCardNumber()+ "\n";
		
		try{
    		File file =new File("customer.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	List<PersonCustomer> getCustomer() throws IOException
	{
		List<PersonCustomer> customers = new ArrayList<PersonCustomer>();
		try {
			FileReader fr = new FileReader("customer.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				
				String[] tokens = line.split("|");
				int id = Integer.parseInt(tokens[0]);
				String[] name = tokens[1].split(" ");
				String first = name[0];
				String last = name[1];
				String email = tokens[2];
				String address = tokens[3];
				String telephone=tokens[4];
				int card=Integer.parseInt(tokens[5]);
				
				PersonCustomer customer = new PersonCustomer(first, last, email, "", address, telephone, id, card);
				customers.add(customer);			
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return customers;
	}
	
	public void saveVehicle(Vehicle vehicle)
	{
		String classification=vehicle.getClassification();
		double weight = vehicle.getMaxWeight();
		String model = vehicle.getModel();
		String feature = vehicle.getSpecialFeatures();
		double[] dim = vehicle.getStorageDimensions();
		double length=dim[0];
		double width=dim[1];
		double height=dim[2];
		
		
		try{
    		String data = classification + "|" + weight + "|" + model + "|" +  feature + "|" +  length + "|" +  width + "|" +  height + "\n";
    		
    		File file =new File("vehicle.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	public void saveParcel(Parcel parcel)
	{
		String description=null!=parcel.getDescription() ? parcel.getDescription() : "des";
		int[] dim=parcel.getDimensions();
		int length=dim[0];
		int width=dim[1];
		int height=dim[2];
		int id=parcel.getParcelID();
		String requirements = parcel.getSpecialRequirements();
		int urgent = parcel.getUrgency();
		double weight = parcel.getWeight();
		
		
		try{
    		String data = id + "|" + description + "|" + length + "|" +  width + "|" +  height + "|" +  weight + "|" +  urgent + "|" +  requirements + "\n";
    		
    		File file =new File("parcel.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(data);
    	        bufferWritter.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	List<Parcel> getParcels() throws IOException
	{
		List<Parcel> parcels = new ArrayList<Parcel>();
		try {
			FileReader fr = new FileReader("parcel.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				String description="";
				int[] dim={0,0,0};
				int length;
				int width;
				int height;
				int id;
				String requirements;
				int urgent;
				double weight;
				
				String[] tokens = line.split("|");
				id=Integer.parseInt(tokens[0]);
				description=tokens[1];
				length=Integer.parseInt(tokens[2]);
				width=Integer.parseInt(tokens[3]);
				height=Integer.parseInt(tokens[4]);
				dim[0]=length;
				dim[1]=width;
				dim[3]=height;
				weight=Double.parseDouble(tokens[5]);
				urgent=Integer.parseInt(tokens[6]);
				requirements=tokens[7];
				
				Parcel parcel = new Parcel(description, id, dim, weight, requirements, urgent);
				parcels.add(parcel);			
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return parcels;
	}

	List<Vehicle> getVehicles() throws IOException
	{
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			FileReader fr = new FileReader("vehicle.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				String classification;
				String model;
				String feature;
				double[] dim={0,0,0};
				double length;
				double width;
				double height;
				double weight;
				
				String[] tokens = line.split("|");
				classification = tokens[0];
				model = tokens[2];
				feature = tokens[3];
				length=Double.parseDouble(tokens[4]);
				width=Double.parseDouble(tokens[5]);
				height=Double.parseDouble(tokens[6]);
				dim[0]=length;
				dim[1]=width;
				dim[3]=height;
				weight=Double.parseDouble(tokens[1]);
				
				Vehicle vehicle = new SmallVan(model, weight, dim, feature, classification);
				vehicles.add(vehicle);			
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return vehicles;
	}
	
	

	
}