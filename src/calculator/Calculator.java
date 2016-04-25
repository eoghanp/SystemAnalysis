package calculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Vehicle.LocationUpdater;
import Vehicle.Subject;
import Vehicle.Vehicle;
import Vehicle.VehicleFactory;
import Works.Order;
import dataIO.DBHandler;
import parcel.Parcel;
import route.Route;

public class Calculator {
	
	public Calculator(){
		
	}
	
	public double getDeliveryCost(List<Parcel> parcels, int priority){
		Parcel p;
		double cost = 0.0, size;
		int sizeArr[];
		
		if (priority == 0)
			cost = 10;
		else
			cost = 25;
		
		for (int i = 0; i < parcels.size(); i++){
			p = parcels.get(i);
			sizeArr = p.getDimensions();
			size = sizeArr[0] * sizeArr[1] * sizeArr[2];
			
			if (size < 20)
				cost += 10;
			else if (size < 40)
				cost += 15;
			else if (size < 60)
				cost += 20;
			else
				cost += 25;
			
			switch (p.getSpecialRequirements()){
			case "none":;
				break;
			case "fridge": cost += 15;
				break;
			case "freezer": case "tanker": cost += 25;
				break;
			case "livestock": cost += 35;
				break;
			}
			
			switch (p.getUrgency()){
			case 0:;
				break;
			case 1: cost += 10;
				break;
			case 2: cost += 25;
				break;
			}
		}
		//add stuff for distance
		return cost;
	}
	
	public List<Route> calculateRoutes(List<Order> listOfOrders){
		RoutingInterface routingAlgoritm1 = new RoutingAlgorithm1();
		RoutingInterface routingAlgoritm2 = new RoutingAlgorithm2();
		Thread r1 = (Thread) routingAlgoritm1;
		Thread r2 = (Thread) routingAlgoritm2;
		r1.start();
		r2.start();
		
		DBHandler db = DBHandler.getSingletonInstance();
		List<Route> routes = new ArrayList<Route>();
		String descriptions[] = {"North", "South", "East", "West", "Central"};
		String vehicles[] = {"smallvan", "largevan", "smalllorry", "largelorry"};
		
		int a = 0, numRoutes = listOfOrders.size()/5;
		if (listOfOrders.size()%5 != 0)
			numRoutes++;
		for (int i = 0; i < numRoutes; i++){
			
			int max = 0;
			try {
				List<Route> c = db.getRoutes();
				for(int x = 0; x < c.size(); x++)
					if(c.get(x).getRouteId() > max)
						max = c.get(x).getRouteId();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			routes.add(new Route(max+1, null));
			
			for (int j = 0; j < 5 && a < listOfOrders.size(); j++){
				routes.get(i).addJob(listOfOrders.get(a));
				a++;
			}
		}
		
		VehicleFactory vf = new VehicleFactory();
		for (int i = 0; i < routes.size(); i++){
			routes.get(i).setRouteDetails(descriptions[((int)(Math.random()*5))]);
			routes.get(i).setDistance((((int)(Math.random()*400) + 50)));//use order details in future
			Vehicle vehicle = vf.getVehicle(vehicles[((int)(Math.random() * 3))]);
			routes.get(i).assignVehicle(vehicle);//more complex in future - use parcel requirements
			db.saveRoute(routes.get(i));
			Subject subject = (Subject) vehicle;
			subject.registerObserver(routes.get(i));
			LocationUpdater lu = new LocationUpdater(vehicle);
			lu.start();
		}
		
		return routes;
	}
}
