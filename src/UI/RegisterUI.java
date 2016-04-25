package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Users.PersonCustomer;
import dataIO.DBHandler;
import Users.Customer;
import Users.LoginDetails;

public class RegisterUI extends JPanel implements ActionListener {

	private JComboBox cmbLoginTypeList;
	private JLabel userNameLbl;
	private JLabel passwordLbl;
	private JLabel typeLbl;
	private JTextField userNameTxt;
	private JPasswordField passwordPwd;
	private JButton registerBtn;
	private int loginType = 0;
	
	
	
	public RegisterUI() {
		setLayout(null);
		
		userNameLbl = new JLabel("Email/Username");
		userNameLbl.setBounds(75, 75, 180, 25);
		add(userNameLbl);

		userNameTxt = new JTextField(20);
		userNameTxt.setBounds(180, 75, 200, 25);
		add(userNameTxt);
				
		passwordLbl = new JLabel("Password");
		passwordLbl.setBounds(75, 105, 180, 25);
		add(passwordLbl);

		passwordPwd = new JPasswordField(20);
		passwordPwd.setBounds(180, 105, 200, 25);
		add(passwordPwd);
		
		typeLbl = new JLabel("Type");
		typeLbl.setBounds(75, 140, 180, 25);
		add(typeLbl);
		
		String[] arrLoginType = {"Manager", "Business", "Customer"};
		cmbLoginTypeList = new JComboBox(arrLoginType);
		cmbLoginTypeList.setBounds(180, 140, 200, 25);
		cmbLoginTypeList.setSelectedIndex(2);
		cmbLoginTypeList.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent ae)
	        {
				String type = "";
				if (ae.getSource() == cmbLoginTypeList) {
						JComboBox cb = (JComboBox)ae.getSource();
						type = (String)cb.getSelectedItem();
						System.out.println("Type is: " + type);
						switch (type) {
						case "Manager" : loginType = 0; System.out.println(loginType); //Manager 
							break;
						case "Business" : loginType = 1; System.out.println(loginType); //Business
							break;
						case "Customer" : loginType = 2; System.out.println(loginType); //Customer
							break;
						default:
							break;
						}
					}
	        }
	    });
		add(cmbLoginTypeList);
		
		registerBtn = new JButton("Create Account");
		registerBtn.setBounds(243, 200, 140, 25);
		add(registerBtn);
		registerBtn.addActionListener(this);
		registerBtn.setActionCommand("createAccount");
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if ("createAccount".equals(evt.getActionCommand())) {
			String userName = userNameTxt.getText();
			String passText = new String(passwordPwd.getPassword());
			System.out.println(passText);
				
			Customer c = new PersonCustomer(userName, passText);
			DBHandler db = DBHandler.getSingletonInstance();
			db.saveCustomer((PersonCustomer) c);
			ArrayList<LoginDetails> loginDetailsList = new ArrayList<LoginDetails>();
			FileWriter aFileWriter = null;
			try {
				aFileWriter = new FileWriter("login.txt", true);
				//aFileWriter = new FileWriter("login2.txt");
				
				PrintWriter out = new PrintWriter(aFileWriter);

				
				LoginDetails addLoginDetails = new LoginDetails(loginType, userName, passText);
				loginDetailsList.add(addLoginDetails);
				System.out.println(loginDetailsList.get(0).getLoginType() + "," + loginDetailsList.get(0).getUserName() + 
						 "," + loginDetailsList.get(0).getPassword());
					
				out.println(loginDetailsList.get(0).getLoginType() + "," + loginDetailsList.get(0).getUserName() + 
						"," + loginDetailsList.get(0).getPassword());

				aFileWriter.close();
				out.close();
			} catch (IOException e) {
					
			}
		}
	}
}