package dataIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import route.Route;
import Business.BusinessCustomer;
import Users.Courier;
import Users.Customer;
import Users.LoginDetails;
import Users.PersonCustomer;
import Users.Person;
import Users.Recipient;
import Vehicle.SmallVan;
import Vehicle.Vehicle;
import Works.Job;
import Works.Order;
import parcel.Parcel;

public class DBHandler {
	
	private static DBHandler singletonInstance;
	private static ArrayList<LoginDetails> loginDetailsList = new ArrayList<LoginDetails>();
	private static int l = 0;
	
	public static DBHandler getSingletonInstance(){
		if(singletonInstance == null)
			singletonInstance = new DBHandler();
		return singletonInstance;
	}
	
	public static boolean loginUser(String email, String password) {
		try {
			File loginFile = new File("login.txt");
			Scanner aFileScanner = new Scanner(loginFile);	
			String aLineFromFile;

			while (aFileScanner.hasNext()) {
				aLineFromFile = aFileScanner.nextLine();
				String details[] = aLineFromFile.split(",");
				
				int loginType = Integer.parseInt(details[0]);
				String userName = details[1];
				String passwordList = details[2];
				
				LoginDetails addLoginDetails = new LoginDetails(loginType, userName, passwordList);

				loginDetailsList.add(addLoginDetails);
			}
			aFileScanner.close();
			
			while (l < loginDetailsList.size()) {
				if (email.equalsIgnoreCase(loginDetailsList.get(l).getUserName()) && 
						password.equals(loginDetailsList.get(l).getPassword())) {
					return true;
				}
				++l;
			}
			
		} catch (FileNotFoundException fileNotFound) {
			fileNotFound.printStackTrace();
		}
		return false;
	}
	
	public static int retrieveLoginType() {
		return loginDetailsList.get(l).getLoginType();
	}
	
	public boolean isValidLogin(String email, String password) 
	{
		if(email == null && password == null) {
			return false;
		}

		try {
			File loginFile = new File("login.txt");
			Scanner aFileScanner = new Scanner(loginFile);	
			String aLineFromFile;

			while (aFileScanner.hasNext()) {
				aLineFromFile = aFileScanner.nextLine();
				String details[] = aLineFromFile.split(",");
				
				int loginType = Integer.parseInt(details[0]);
				String userName = details[1];
				String passwordList = details[2];
				
				LoginDetails addLoginDetails = new LoginDetails(loginType, userName, passwordList);

				loginDetailsList.add(addLoginDetails);
			}
			aFileScanner.close();
		} catch (FileNotFoundException fileNotFound) {
			fileNotFound.printStackTrace();
		}
		
		for(int j = 0; j < loginDetailsList.size(); j++) {
			if (email.equalsIgnoreCase(loginDetailsList.get(j).getUserName()) && 
					password.equals(loginDetailsList.get(j).getPassword())) {
				return true;
			}
		}
		return false;
	}
	
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
				
				String[] tokens = line.split("\\|");
				Address = tokens[0];
				BusinessCard = tokens[2];
				BusinessDetails = tokens[3];
				CardNumber=Integer.parseInt(tokens[4]);
				Email=tokens[4];
				Name=tokens[5];
				Telephone=Integer.parseInt(tokens[6]);
				
				BusinessCustomer businesses = new BusinessCustomer(Name, Address, Email, BusinessCard, Telephone, CardNumber);
				business.add(businesses);	
				
				br.close();
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
		data += order.getStatus() + "|";
		data += order.getOrderID() + "\n";
		
		try{
    		File file =new File("order.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        PrintWriter pw = new PrintWriter(bufferWritter);
    	        pw.println(data);
    	        bufferWritter.close();
    	        pw.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	
	public List<Order> getOrder() throws IOException
	{
		List<Order> orders = new ArrayList<Order>();
		try {
			FileReader fr = new FileReader("order.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				String[] tokens = line.split("\\|");
				int id = Integer.parseInt(tokens[0]);
				boolean paid = Boolean.getBoolean(tokens[1]);
				String [] parcels = tokens[2].split("#");
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
					dim[2]=height;
					weight=Double.parseDouble(tokensp[5]);
					urgent=Integer.parseInt(tokensp[6]);
					requirements=tokensp[7];
					
					Parcel parcelp = new Parcel(description, idp, dim, weight, requirements, urgent);
					parcel.add(parcelp);
				}
				Double price = Double.parseDouble(tokens[3]);
				int priority=Integer.parseInt(tokens[4]);
				String tokensr[] = tokens[5].split("%");
				String add =tokensr[0];
				String []name =tokensr[1].split(" ");
				String first = name[0];
				String last = name[1];
				String phone =tokensr[2];
				String status = tokensr[3];
				int id2 = Integer.parseInt(tokens[6]);
				
				
				Recipient rec = new Person(first, last, "", "", add, phone);
				Order order = new Order(id2, parcel, rec, price, priority, null, status);
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
		data+=courier.getPassword()+ "|";
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
    	       // bufferWritter.write(data);
    	        PrintWriter pw = new PrintWriter(bufferWritter);
    	        pw.println(data);
    	        pw.println();
    	        bufferWritter.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
		
	}
	
	public List<Courier> getCourier() throws IOException
	{
		List<Courier> couriers = new ArrayList<Courier>();
		try {
			FileReader fr = new FileReader("courier.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				
				String[] tokens = line.split("\\|");
				int id = Integer.parseInt(tokens[0]);
				String address = tokens[1];
				String email = tokens[2];
				String password = tokens[3];
				String[] name = tokens[4].split(" ");
				String first = name[0];
				String last = name[1];
				String telephone=tokens[5];
				
				Courier corior = new Courier(first, last, email, password, address, telephone, id);
				couriers.add(corior);			
			}	
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return couriers;
	}
	
	public Courier getThisCourier(String uName, String pass){
		try {
			List<Courier> c = getCourier();
			for(int i = 0; i < c.size(); i++){
				if(c.get(i).getEmail().equals(uName) && c.get(i).getPassword().equals(pass)){
					return c.get(i);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
    	        PrintWriter pw = new PrintWriter(bufferWritter);
    	        pw.println(data);
    	        bufferWritter.close();
    	        pw.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	public Customer getThisCustomer(String uName, String pass){
		try {
			List<PersonCustomer> c = getCustomer();
			for(int i = 0; i < c.size(); i++){
				if(c.get(i).getEmail().equals(uName) && c.get(i).getPassword().equals(pass)){
					return (Customer)c.get(i);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void saveRoute(Route route)
	{
		String data ="";

		data+=route.getRouteId()+ "|";
		data+=route.getRouteDetails()+ "|";
		data+=route.getVehicle()+ "|";
		data+=route.getDistance()+ "|";
		List<Job> jobs = route.getJobs();
		for(int i = 0; i < jobs.size(); i++)
			data+=jobs.get(i).getOrderID() + ",";
		//data+="\n";
		try{
    		File file =new File("routes.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        PrintWriter pw = new PrintWriter(bufferWritter);
    	        pw.println(data);
    	       // pw.println();
    	        bufferWritter.close();
    	        pw.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	public List<Route> getRoutes() throws IOException
	{
		List<Route> allRoutes = new ArrayList<Route>();
		try {
			FileReader fr = new FileReader("routes.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				
				String[] tokens = line.split("\\|");
				int id = Integer.parseInt(tokens[0]);
				String details = tokens[1];
				String vehicle = tokens[2];
				int distance = Integer.parseInt(tokens[3]);
				String[] jobs = tokens[4].split(",");
				List<Order> allJobs = getOrder();
				List<Job> myJobs = new ArrayList<Job>();
				for(int i = 0; i < allJobs.size(); i++){
					for(int j = 0; j < jobs.length-1; j++){
						if (allJobs.get(i).getOrderID() == Integer.parseInt(jobs[j]))
							myJobs.add(allJobs.get(i));	
					}
				}
				
				Route route = new Route(id, details, distance, myJobs);	
				allRoutes.add(route);
			}		
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allRoutes;
	}
	
	public void assignRoute(int rId, int cId){
		String data ="";

		data+=rId+ "|";
		data+=cId;
		try{
    		File file =new File("assignedRoutes.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
    		
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        PrintWriter pw = new PrintWriter(bufferWritter);
    	        pw.println(data);
    	        //pw.println();
    	        bufferWritter.close();
    	        pw.close();
    	    
	        System.out.println(data+" saved");
	        
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	
	public Route getSpecificRoute(int id){
		try {
			FileReader fr = new FileReader("assignedRoutes.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				
				String[] tokens = line.split("\\|");
				int cId = Integer.parseInt(tokens[0]);
				int rId = Integer.parseInt(tokens[1]);
				if(cId == id){
					List<Route> routes = getRoutes();
					for(int i = (routes.size()-1); i >= 0; i--){
						if(routes.get(i).getRouteId() == rId){
							return routes.get(i);
						}
					}
				}
			}	
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PersonCustomer> getCustomer() throws IOException
	{
		List<PersonCustomer> customers = new ArrayList<PersonCustomer>();
		try {
			FileReader fr = new FileReader("customer.txt");
			BufferedReader br = new BufferedReader(fr);
			//Read file line by line
			String line;
			while ( ( line = br.readLine( ) ) != null ) {
				
				
				String[] tokens = line.split("\\|");
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
			br.close();
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
				
				String[] tokens = line.split("\\|");
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
			br.close();
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
				
				String[] tokens = line.split("\\|");
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
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return vehicles;
	}
	
	

	
}