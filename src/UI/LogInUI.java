package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Users.Customer;
import Users.Courier;
import Users.Manager;

public class LogInUI extends JPanel implements ActionListener {

	protected JLabel userNameLbl;
	protected JLabel passwordLbl;
	protected JTextField userNameTxt;
	protected JPasswordField passwordPwd;
	protected JButton logInBtn;
	protected JButton registerBtn;
	
	
	
	public LogInUI(Customer customer) {
		setLayout(null);

		userNameLbl = new JLabel("Username");
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
		
		logInBtn = new JButton("Log in");
		logInBtn.setBounds(313, 135, 70, 25);
		add(logInBtn);
		logInBtn.addActionListener(this);
		logInBtn.setActionCommand("logIn");
		
		registerBtn = new JButton("Register");
		registerBtn.setBounds(185, 135, 75, 20);
		add(registerBtn);
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if ("logIn".equals(evt.getActionCommand())) {
			String passText = new String(passwordPwd.getPassword());
			System.out.println(passText);
			if ((!(userNameTxt.getText().equals(""))) && (!(passText.equals("")))) {
				ArrayList<String> loginCredentials = new ArrayList<String>();
				try {
					File loginFile = new File("login.txt");
					Scanner aFileScanner = new Scanner(loginFile);	
					String aLineFromFile;
					boolean loggedIn = false;
					
					while ((!loggedIn) && aFileScanner.hasNext()) {
						aLineFromFile = aFileScanner.nextLine();
						String details[] = aLineFromFile.split(",");
						
						if (userNameTxt.getText().equalsIgnoreCase(details[0]) && passText.equals(details[1])) {
							JOptionPane.showMessageDialog(null, "Logged in!");
							loggedIn = true; break;
						}
						else if ((!(userNameTxt.getText().equalsIgnoreCase(details[0])) && (!(passText.equals(details[1]))))) {
							JOptionPane.showMessageDialog(null, "Incorrect Username/Password.");
						}
					}
				} catch (FileNotFoundException fileNotFound) {
					JOptionPane.showMessageDialog(null, "Can't find a text file");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Enter a username and password.");
			}
		} else {
	        System.exit(0);
		}
	}
}