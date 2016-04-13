package UI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.*;
import javax.swing.*;

import Users.Customer;
import Users.Manager;
import Works.Order;
import data.Parcel;

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

		Order o = new Order(null, manager, 0, 0);
		Manager m = new Manager(null, null, null, null, null, null);
		try {
			m.printReport(o);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//testLogin();
		
	   /* manager = new Manager(null, null, null, null, null, null);
	    testPurchaseService();
	    //Thread.sleep(30000);
	    testAddCourier();
	    Thread.sleep(180000);
	    testAssignCourier();*/

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
	
	private static void testLogin(){
		JFrame addCourierFrame = new JFrame("Login");
		addCourierFrame.setSize(500, 300);
		addCourierFrame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });

		addCourierFrame.getContentPane().add(new LogInUI());
		addCourierFrame.setVisible(true);
	}
	
}
