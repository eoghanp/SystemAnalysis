package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Users.Manager;
import data.Parcel;
import Users.Courier;
import Users.LoginDetails;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class ManagerUI extends JPanel implements ActionListener
{
	  protected JTextField courierFirstNametxt;
	  protected JTextField courierLastNametxt;
	  protected JTextField courierIDtxt;
	  protected JTextField emailtxt;
	  protected JTextField passwordtxt;
	  protected JTextField addresstxt;
	  protected JTextField contacttxt;

	  protected Manager man;
	  protected Courier employee;
	  
	  public ManagerUI(Manager manager) 
	  {
		
		man = manager;
		setLayout(null);
		//First Name
		JLabel firstNamelbl = new JLabel("First Name");
		firstNamelbl.setBounds(20, 10, 180, 25);
		add(firstNamelbl);
		courierFirstNametxt = new JTextField(20);
		courierFirstNametxt.setBounds(120, 10, 200, 25);
		add(courierFirstNametxt);
		//Last Name
		JLabel lastNamelbl = new JLabel("Last Name");
		lastNamelbl.setBounds(20, 40, 180, 25);
		add(lastNamelbl);
		courierLastNametxt = new JTextField(20);
		courierLastNametxt.setBounds(120, 40, 200, 25);
		add(courierLastNametxt);
		//ID
		JLabel IDlbl = new JLabel("Employee ID");
		IDlbl.setBounds(20, 70, 180, 25);
		add(IDlbl);
		courierIDtxt = new JTextField(20);
		courierIDtxt.setBounds(120, 70, 200, 25);
		add(courierIDtxt);
		//Email
		JLabel emaillbl = new JLabel("Employee Email");
		emaillbl.setBounds(20, 100, 180, 25);
		add(emaillbl);
		emailtxt = new JTextField(20);
		emailtxt.setBounds(120, 100, 200, 25);
		add(emailtxt);
		//Password
		JLabel passwordlbl = new JLabel("Set Password");
		passwordlbl.setBounds(20, 130, 180, 25);
		add(passwordlbl);
		passwordtxt = new JTextField(20);
		passwordtxt.setBounds(120, 130, 200, 25);
		add(passwordtxt);
		//Address
		JLabel addresslbl = new JLabel("Address");
		addresslbl.setBounds(20, 160, 180, 25);
		add(addresslbl);
		addresstxt = new JTextField(20);
		addresstxt.setBounds(120, 160, 200, 25);
		add(addresstxt);
		//Contact
		JLabel contactlbl = new JLabel("Contact");
		contactlbl.setBounds(20, 190, 180, 25);
		add(contactlbl);
		contacttxt = new JTextField(20);
		contacttxt.setBounds(120, 190, 200, 25);
		add(contacttxt);
		
		//Add Courier
		JButton purchaseButton = new JButton("Add Courier");
		purchaseButton.setBounds(330, 230, 150, 25);
		add(purchaseButton);
		purchaseButton.addActionListener(this);
		purchaseButton.setActionCommand("Add Courier");

	  }
	 
	  public void actionPerformed(ActionEvent evt) 
	  {
		  boolean isInteger = Pattern.matches("\\d{1,5}", courierIDtxt.getText());
		  if ("Add Courier".equals(evt.getActionCommand())) 
		  {
			if ((courierFirstNametxt.getText().equals("")) || (courierLastNametxt.getText().equals("")) || (courierIDtxt.getText().equals("")) || (emailtxt.getText().equals("")) || (passwordtxt.getText().equals("")) || (addresstxt.getText().equals("")) || (contacttxt.getText().equals("")))
			  {
				  JOptionPane.showMessageDialog(null, "You must enter details in all text fields", "Enter all data", 2);
			  }
			  else if(isInteger == false)
			  {
				  JOptionPane.showMessageDialog(null, "Employee ID must be an integer", "Employee ID", 2);
			  }
			  else{
				  Courier employee = new Courier(courierFirstNametxt.getText(),courierLastNametxt.getText(),emailtxt.getText(),passwordtxt.getText(),addresstxt.getText(),contacttxt.getText(),Integer.parseInt(courierIDtxt.getText()));
				  man.addCourier(employee);
				  
					FileWriter aFileWriter = null;
					try {
						aFileWriter = new FileWriter("login.txt", true);
						//aFileWriter = new FileWriter("login2.txt");
						
						PrintWriter out = new PrintWriter(aFileWriter);

						Scanner in = new Scanner(System.in);
						
						System.out.println("3" + "," + emailtxt.getText() + 
								 "," + passwordtxt.getText());
							
						out.println("3" + "," + emailtxt.getText() + 
								 "," + passwordtxt.getText());

						aFileWriter.close();
						out.close();
					} catch (IOException e) {
							
					}
				  JOptionPane.showMessageDialog(null, employee.showCourierDetails(), "Courier created", 1);
				  clearCourierForm();
			  }			  
			
		  }
	  }
	  
	  private void clearCourierForm(){
		  courierFirstNametxt.setText("");
		  courierLastNametxt.setText("");
		  courierIDtxt.setText("");
		  emailtxt.setText("");
		  passwordtxt.setText("");
		  addresstxt.setText("");
		  contacttxt.setText("");
	  }


}
