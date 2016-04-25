package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Users.PersonCustomer;
import Users.Customer;
import Users.Manager;

public class MainCustomerScreen  extends JPanel implements ActionListener{

	public MainCustomerScreen(Customer customer) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel mainlbl = new JLabel("Menu:");
		mainlbl.setBounds(250, 50, 150, 25);
		add(mainlbl);
		
		JButton editACButton = new JButton("Edit Account");
		editACButton.setBounds(200, 100, 150, 25);
		add(editACButton);
		editACButton.addActionListener(this);
		editACButton.setActionCommand("Edit AC");
		
		JButton purchaseButton = new JButton("Purchase Service");
		purchaseButton.setBounds(200, 200, 150, 25);
		add(purchaseButton);
		purchaseButton.addActionListener(this);
		purchaseButton.setActionCommand("purchase");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Edit AC".equals(e.getActionCommand())) 
		{
			System.out.println("Edit Account");
			JOptionPane.showMessageDialog(null, "This feature is currently under development");
		}
		else if("purchase".equals(e.getActionCommand())) 
		{
			JFrame frame = new JFrame("Purchase Service");
			frame.setSize(900, 550);
			Manager manager = new Manager(null, null, null, null, null, null);
			PersonCustomer customer = new PersonCustomer(null, null, null, null, null, null, 0, 0);
			frame.getContentPane().add(new CustomerUI(customer, manager));
			frame.setVisible(true);
		}
	}

}
