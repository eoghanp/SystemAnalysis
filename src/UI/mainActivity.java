package UI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.*;
import javax.swing.*;

import Users.Customer;
import data.Parcel;
import Users.Manager;

public class mainActivity {

	public static void main(String[] args) {
		/*Customer customer = new Customer(null, null, null, null, null, null, 0, 0);
		int dims[] = {10, 5, 5};
		Parcel p1 = new Parcel(01, dims, 20, "none", 1);
		List<Parcel> l = new ArrayList<Parcel>();
		l.add(p1);
		customer.purchaseService(l);*/
		
		/*Customer customer = new Customer(null, null, null, null, null, null, 0, 0);
		
		JFrame frame = new JFrame("Purchase Service");
	    frame.setSize(900, 550);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });

	    frame.getContentPane().add(new CustomerUI(customer));
	    frame.setVisible(true);*/
	    
	    
		Manager manager = new Manager(null, null, null, null, null, null, null);
		
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
	
}
