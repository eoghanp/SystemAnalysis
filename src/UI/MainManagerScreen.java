package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Users.Manager;

public class MainManagerScreen extends JPanel implements ActionListener{

	private Manager manager;
	
	public MainManagerScreen(Manager man) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		manager = man;
		
		JLabel mainlbl = new JLabel("Menu:");
		mainlbl.setBounds(250, 50, 150, 25);
		add(mainlbl);
		
		JButton addButton = new JButton("Add Courier");
		addButton.setBounds(200, 100, 150, 25);
		add(addButton);
		addButton.addActionListener(this);
		addButton.setActionCommand("Add Courier");
		
		JButton purchaseButton = new JButton("Assign Couriers");
		purchaseButton.setBounds(200, 150, 150, 25);
		add(purchaseButton);
		purchaseButton.addActionListener(this);
		purchaseButton.setActionCommand("Assign Couriers");
		
		JButton reviewButton = new JButton("Review Deliveries");
		reviewButton.setBounds(200, 200, 150, 25);
		add(reviewButton);
		reviewButton.addActionListener(this);
		reviewButton.setActionCommand("Review Deliveries");
		
		JButton DBButton = new JButton("View Database");
		DBButton.setBounds(200, 250, 150, 25);
		add(DBButton);
		DBButton.addActionListener(this);
		DBButton.setActionCommand("View Database");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Add Courier".equals(e.getActionCommand())) 
		{
			JFrame frame = new JFrame("Add Courier");
			frame.setSize(500, 300);
			frame.getContentPane().add(new ManagerUI(manager));
			frame.setVisible(true);
		}
		else if("Assign Couriers".equals(e.getActionCommand())) 
		{
			JFrame frame = new JFrame("Assign Courier");
			frame.setSize(600, 600);
			try {
				frame.getContentPane().add(new AssignCourierUI(manager));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.setVisible(true);
		}
		else if("Review Deliveries".equals(e.getActionCommand())) 
		{
			JFrame frame = new JFrame("Review Deliveries");
			frame.setSize(600, 450);
			frame.getContentPane().add(new ReviewJobsUI(manager));
			frame.setVisible(true);
		}
		
	}

}
