package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Users.Customer;
import data.Parcel;

public class CustomerUI extends JPanel implements ActionListener {

  protected JTextField collectiontxt;
  protected JTextField receipientNametxt;
  protected JTextField receipientAddrtxt;
  protected JTextField receipientPhonetxt;
  
  public CustomerUI() {
	  
	  setLayout(null);

		JLabel collectionlbl = new JLabel("Collection Address");
		collectionlbl.setBounds(10, 10, 180, 25);
		add(collectionlbl);

		collectiontxt = new JTextField(20);
		collectiontxt.setBounds(180, 10, 200, 25);
		add(collectiontxt);

		JLabel receipientNamelbl = new JLabel("Receipient Name");
		receipientNamelbl.setBounds(10, 40, 180, 25);
		add(receipientNamelbl);

		receipientNametxt = new JTextField(20);
		receipientNametxt.setBounds(180, 40, 200, 25);
		add(receipientNametxt);
		
		JLabel receipientAddrlbl = new JLabel("Receipient Address");
		receipientAddrlbl.setBounds(10, 70, 180, 25);
		add(receipientAddrlbl);

		receipientAddrtxt = new JTextField(20);
		receipientAddrtxt.setBounds(180, 70, 200, 25);
		add(receipientAddrtxt);
		
		JLabel receipientPhonelbl = new JLabel("Receipient Phone Number");
		receipientPhonelbl.setBounds(10, 100, 180, 25);
		add(receipientPhonelbl);

		receipientPhonetxt = new JTextField(20);
		receipientPhonetxt.setBounds(180, 100, 200, 25);
		add(receipientPhonetxt);

		JButton parcelButton = new JButton("Add Parcel");
		parcelButton.setBounds(10, 180, 150, 25);
		add(parcelButton);
		parcelButton.addActionListener(this);
		parcelButton.setActionCommand("parcel");
		
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.setBounds(210, 180, 150, 25);
		add(purchaseButton);
		purchaseButton.addActionListener(this);
		purchaseButton.setActionCommand("purchase");
	  
  }

  public void actionPerformed(ActionEvent evt) {
	  if ("purchase".equals(evt.getActionCommand())) {
		  Customer customer = new Customer(null, null, null, null, null, null, 0, 0);
			int dims[] = {10, 5, 5};
			Parcel p1 = new Parcel(01, dims, 20, "none", 1);
			List<Parcel> l = new ArrayList<Parcel>();
			l.add(p1);
			customer.purchaseService(l);
	        System.out.println(collectiontxt.getText());
	    }else if ("parcel".equals(evt.getActionCommand())){
	    	 System.out.println("add parcel");
	    }else {
	        System.exit(0);
	    }
  }
}