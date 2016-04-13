package UI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.*;
import javax.swing.*;

import Users.Customer;
import Users.Manager;
import Vehicle.Vehicle;
import data.Parcel;
import route.Route;

public class mainActivity {

	//protected static JFrame frame;
	protected static Manager manager;
	
	public static void main(String[] args) throws InterruptedException {
		/*frame = new JFrame("Courier Service");
	    frame.setSize(900, 550);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });*/
		//testObserverDesignPattern();
	    manager = new Manager(null, null, null, null, null, null);
	    //testPurchaseService();
	    //Thread.sleep(30000);
	    //testAddCourier();
	    //Thread.sleep(180000);
	    //testAssignCourier();
	   // testCustomerGui();
	    //testManagerGui();
	    testLogin();
	}

	private static void testLogin() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Login");
		frame.setSize(600, 600);
		frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		
		frame.getContentPane().add(new LogInUI());
		frame.setVisible(true);
	}

	private static void testManagerGui() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Manager");
		frame.setSize(600, 600);
		frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		frame.getContentPane().add(new MainManagerScreen());
		frame.setVisible(true);
		
	}

	private static void testCustomerGui() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Customer");
		frame.setSize(600, 600);
		frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		frame.getContentPane().add(new MainCustomerScreen());
		frame.setVisible(true);
	}

	private static void testAssignCourier() {
		JFrame frame = new JFrame("Assign Courier");
		frame.setSize(600, 600);
		frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		frame.getContentPane().add(new AssignCourierUI(manager));
		frame.setVisible(true);
	}

	private static void testPurchaseService() {
		JFrame frame = new JFrame("Purchase Service");
		frame.setSize(900, 550);
		frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		Customer customer = new Customer(null, null, null, null, null, null, 0, 0);
		frame.getContentPane().add(new CustomerUI(customer, manager));
		frame.setVisible(true);
		
	}
	
	private static void testAddCourier(){
		//Manager manager = new Manager(null, null, null, null, null, null, null);
		
		JFrame addCourierFrame = new JFrame("Add Courier");
		addCourierFrame.setSize(500, 300);
		addCourierFrame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });

		addCourierFrame.getContentPane().add(new ManagerUI(manager));
		addCourierFrame.setVisible(true);
	}
	
	private static void testObserverDesignPattern(){
		Route aRoute = new Route(0, "null");
		Vehicle aVehicle = new Vehicle("null",0.0,null,null,null);
		aVehicle.registerObserver(aRoute);
		aVehicle.setLocation("Limerick");
		aVehicle.setLocation("Offaly");
	}

	
}
