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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dataIO.DBHandler;
import Users.Manager;

public class LogInUI extends JPanel implements ActionListener {

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Login");
		frame.setSize(500, 300);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add(new LogInUI());
		frame.setVisible(true);
	}

	private JLabel userNameLbl;
	private JLabel passwordLbl;
	private JTextField userNameTxt;
	private JPasswordField passwordPwd;
	private JButton logInBtn;
	private JButton registerBtn;

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
		logInBtn.setBounds(290, 135, 90, 25);
		add(logInBtn);
		logInBtn.addActionListener(this);
		logInBtn.setActionCommand("logIn");

		registerBtn = new JButton("Register");
		registerBtn.setBounds(180, 135, 90, 25);
		add(registerBtn);
		registerBtn.addActionListener(this);
		registerBtn.setActionCommand("Register");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		JFrame frame = new JFrame("MainActivity");
		frame.setSize(600, 400);
		/*
		 * frame.addWindowListener(new WindowAdapter() { public void
		 * windowClosing(WindowEvent e) { System.exit(0); } });
		 */
		if ("logIn".equals(evt.getActionCommand())) {
			String passText = new String(passwordPwd.getPassword());
			System.out.println(passText);

			if (DBHandler.loginUser(userNameTxt.getText(), new String(passwordPwd.getPassword()))) {
				switch (DBHandler.retrieveLoginType()) {

				case 0:
					System.out.println("You are signed in as the Manager.");
					// JOptionPane.showMessageDialog(null, "You are signed in as
					// the Manager.");
					// Execute method

					frame.getContentPane()
							.add(new MainManagerScreen(new Manager("first", "last", "mail", "pass", "add", "phone")));
					frame.setVisible(true);
					break;

				case 1:
					System.out.println("You are signed in as a Business.");
					// JOptionPane.showMessageDialog(null, "You are signed in as
					// a Business.");
					// Execute method

					// frame.getContentPane().add(new MainCustomerScreen());
					// frame.setVisible(true);
					break;

				case 2:
					System.out.println("You are signed in as a Customer.");
					// JOptionPane.showMessageDialog(null, "You are signed in as
					// a Customer.");
					DBHandler db = DBHandler.getSingletonInstance();
					frame.getContentPane().add(new MainCustomerScreen(
							db.getThisCustomer(userNameTxt.getText(), new String(passwordPwd.getPassword()))));
					frame.setVisible(true);
					break;

				case 3:
					System.out.println("You are signed in as a Courier");
					DBHandler db1 = DBHandler.getSingletonInstance();
					frame.getContentPane().add(new MainCourierScreen(
							db1.getThisCourier(userNameTxt.getText(), new String(passwordPwd.getPassword()))));
					frame.setVisible(true);
					break;

				default:
					break;
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Incorrect Details Entered");
		} else if ("Register".equals(evt.getActionCommand())) {
			JFrame frame1 = new JFrame("Register");
			frame1.setSize(575, 350);
			frame1.getContentPane().add(new RegisterUI());
			frame1.setVisible(true);
		}
	}
}