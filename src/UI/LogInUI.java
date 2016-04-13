package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Users.Customer;
import Users.Courier;
import Users.Manager;
import Users.LoginDetails;

public class LogInUI extends JPanel implements ActionListener {

	protected JLabel userNameLbl;
	protected JLabel passwordLbl;
	protected JTextField userNameTxt;
	protected JPasswordField passwordPwd;
	protected JButton logInBtn;
	protected JButton registerBtn;
	
	
	
	public LogInUI() {
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
		registerBtn.addActionListener(this);
		registerBtn.setActionCommand("Register");
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		JFrame frame = new JFrame("MainActivity");
		frame.setSize(600, 600);
		frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
		if ("logIn".equals(evt.getActionCommand())) {
			String passText = new String(passwordPwd.getPassword());
			System.out.println(passText);
				try {
					File loginFile = new File("login.txt");
					Scanner aFileScanner = new Scanner(loginFile);	
					String aLineFromFile;
					
					ArrayList<LoginDetails> loginDetailsList = new ArrayList<LoginDetails>();
					//int i = 0;
					while (aFileScanner.hasNext()) {
						aLineFromFile = aFileScanner.nextLine();
						String details[] = aLineFromFile.split(",");
						
						int loginType = Integer.parseInt(details[0]);
						String userName = details[1];
						String password = details[2];
						
						LoginDetails addLoginDetails = new LoginDetails(loginType, userName, password);

						loginDetailsList.add(addLoginDetails);
					}
					boolean loggedIn = true;
					int i = 0;
					while (i < loginDetailsList.size()) {
						if (userNameTxt.getText().equalsIgnoreCase(loginDetailsList.get(i).getUserName()) && passText.equals(loginDetailsList.get(i).getPassword())) {
							switch(loginDetailsList.get(i).getLoginType())
							{
								case 0 :
									System.out.println("You are signed in as the Manager.");
									//JOptionPane.showMessageDialog(null, "You are signed in as the Manager.");
									//Execute method
									
									frame.getContentPane().add(new MainManagerScreen());
									frame.setVisible(true);
									break;
								
								case 1 :
									System.out.println("You are signed in as a Business.");
									//JOptionPane.showMessageDialog(null, "You are signed in as a Business.");
									//Execute method
									
									frame.getContentPane().add(new MainCustomerScreen());
									frame.setVisible(true);
									break;
								
								case 2 :
									System.out.println("You are signed in as a Customer.");
									//JOptionPane.showMessageDialog(null, "You are signed in as a Customer.");
									//Execute method
									frame.getContentPane().add(new MainCustomerScreen());
									frame.setVisible(true);
									break;
								
								case 3 :
									System.out.println("You are signed in as a Courier");
									frame.getContentPane().add(new MainCourierScreen());
									frame.setVisible(true);
									break;
									
								default: 
									break;
							}	
						}
						++i;
					}
				} catch (FileNotFoundException fileNotFound) {
					JOptionPane.showMessageDialog(null, "Can't find a text file");
				}
			}
		else if ("Register".equals(evt.getActionCommand())) {
			JFrame frame1 = new JFrame("Register");
			frame1.setSize(600, 600);
			frame1.getContentPane().add(new RegisterUI());
			frame1.setVisible(true);
		}
	        //System.exit(0);
		}
}