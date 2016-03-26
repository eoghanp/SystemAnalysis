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
import data.Parcel;

public class mainActivity {

	protected static JFrame frame;
	protected static Manager manager;
	
	public static void main(String[] args) throws InterruptedException {
		frame = new JFrame("Courier Service");
	    frame.setSize(900, 550);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });

	    manager = new Manager();
	    testPurchaseService();
	    Thread.sleep(30000);
	    testAssignCourier();

	}

	private static void testAssignCourier() {
		frame.getContentPane().add(new AssignCourierUI(manager));
		frame.setVisible(true);
	}

	private static void testPurchaseService() {
		Customer customer = new Customer(null, null, null, null, null, null, 0, 0);
		frame.getContentPane().add(new CustomerUI(customer, manager));
		frame.setVisible(true);
		
	}
	
}
