package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Users.Customer;
import Users.Manager;

public class MainManagerScreen extends JPanel implements ActionListener{

	public MainManagerScreen() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JButton addButton = new JButton("Add Courier");
		addButton.setBounds(20, 230, 150, 25);
		add(addButton);
		addButton.addActionListener(this);
		addButton.setActionCommand("Add Courier");
		
		JButton purchaseButton = new JButton("Assign Couriers");
		purchaseButton.setBounds(330, 230, 150, 25);
		add(purchaseButton);
		purchaseButton.addActionListener(this);
		purchaseButton.setActionCommand("Assign Couriers");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Add Courier".equals(e.getActionCommand())) 
		{
			JFrame frame = new JFrame("Add Courier");
			frame.setSize(900, 550);
			frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }
		    });
			Manager manager = new Manager(null, null, null, null, null, null);
			frame.getContentPane().add(new ManagerUI(manager));
			frame.setVisible(true);
		}
		else if("Assign Couriers".equals(e.getActionCommand())) 
		{
			JFrame frame = new JFrame("Purchase Service");
			frame.setSize(900, 550);
			frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }
		    });
			Manager manager = new Manager(null, null, null, null, null, null);
			frame.getContentPane().add(new AssignCourierUI(manager));
			frame.setVisible(true);
		}
		
	}

}
