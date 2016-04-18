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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Users.PersonCustomer;
import Users.Manager;
import Users.Person;
import Users.Customer;
import calculator.Calculator;
import parcel.Parcel;

public class CustomerUI extends JPanel implements ActionListener {

  protected JTextField collectiontxt;
  protected JTextField receipientNametxt;
  protected JTextField receipientAddrtxt;
  protected JTextField receipientPhonetxt;
  protected JTextField descriptiontxt;
  protected JTextField heighttxt;
  protected JTextField widthtxt;
  protected JTextField lengthtxt;
  protected JTextField weighttxt;
  protected JTextField creditCardtxt;
  protected JTextArea parcels;
  protected JTextArea costtxt;
  protected JComboBox<String> specialReqs;
  protected JComboBox<String> deliveryOptions;
  protected String requirements[] = {"none", "fridge", "freezer", "tanker", "livestock"};
  protected String options[] = {"standard", "fast"};
  protected List<Parcel> l = new ArrayList<Parcel>();
  
  protected Customer cust;
  protected Manager man;
  protected Calculator c = new Calculator();
  
  public CustomerUI(PersonCustomer customer, Manager manager) {
	  man = manager;
	  cust = customer;
	  
	  setLayout(null);

	  	JLabel orderlbl = new JLabel("Order Details");
	  	orderlbl.setBounds(160, 10, 180, 25);
		add(orderlbl);
		
		JLabel parcellbl = new JLabel("Parcel Details");
		parcellbl.setBounds(650, 10, 180, 25);
		add(parcellbl);
	  
	  	JLabel collectionlbl = new JLabel("Collection Address");
		collectionlbl.setBounds(10, 75, 180, 25);
		add(collectionlbl);

		collectiontxt = new JTextField(20);
		collectiontxt.setBounds(180, 75, 200, 25);
		add(collectiontxt);

		JLabel receipientNamelbl = new JLabel("Receipient Name");
		receipientNamelbl.setBounds(10, 105, 180, 25);
		add(receipientNamelbl);

		receipientNametxt = new JTextField(20);
		receipientNametxt.setBounds(180, 105, 200, 25);
		add(receipientNametxt);
		
		JLabel receipientAddrlbl = new JLabel("Receipient Address");
		receipientAddrlbl.setBounds(10, 135, 180, 25);
		add(receipientAddrlbl);

		receipientAddrtxt = new JTextField(20);
		receipientAddrtxt.setBounds(180, 135, 200, 25);
		add(receipientAddrtxt);
		
		JLabel receipientPhonelbl = new JLabel("Receipient Phone Number");
		receipientPhonelbl.setBounds(10, 165, 180, 25);
		add(receipientPhonelbl);

		receipientPhonetxt = new JTextField(20);
		receipientPhonetxt.setBounds(180, 165, 200, 25);
		add(receipientPhonetxt);
		
		JLabel deliveryOpts = new JLabel("Delivery Type");
		deliveryOpts.setBounds(10, 230, 180, 25);
		add(deliveryOpts);
		
		deliveryOptions = new JComboBox<String>();
		for (int i = 0; i < options.length; i++)
			deliveryOptions.addItem(options[i]);
		deliveryOptions.setBounds(180, 230, 200, 25);
		add(deliveryOptions);
		
		JLabel creditCardlbl = new JLabel("Credit Card Number");
		creditCardlbl.setBounds(10, 280, 180, 25);
		add(creditCardlbl);

		creditCardtxt = new JTextField(20);
		creditCardtxt.setBounds(180, 280, 200, 25);
		creditCardtxt.setText("" + cust.getCardNumber());
		add(creditCardtxt);
		
		JLabel costlbl = new JLabel("Cost:");
		costlbl.setBounds(10, 370, 180, 25);
		add(costlbl);
		
		costtxt = new JTextArea("");
		costtxt.setBounds(180, 370, 200, 25);
		costtxt.setEditable(false);
		add(costtxt);
		
		JLabel namelbl = new JLabel("Parcel Description");
		namelbl.setBounds(500, 75, 180, 25);
		add(namelbl);

		descriptiontxt = new JTextField(20);
		descriptiontxt.setBounds(670, 75, 200, 25);
		add(descriptiontxt);
		
		JLabel heightlbl = new JLabel("Parcel Height");
		heightlbl.setBounds(500, 105, 180, 25);
		add(heightlbl);

		heighttxt = new JTextField(20);
		heighttxt.setBounds(670, 105, 200, 25);
		add(heighttxt);
		
		JLabel widthlbl = new JLabel("Parcel Width");
		widthlbl.setBounds(500, 135, 180, 25);
		add(widthlbl);

		widthtxt = new JTextField(20);
		widthtxt.setBounds(670, 135, 200, 25);
		add(widthtxt);
		
		JLabel lengthlbl = new JLabel("Parcel Length");
		lengthlbl.setBounds(500, 165, 180, 25);
		add(lengthlbl);

		lengthtxt = new JTextField(20);
		lengthtxt.setBounds(670, 165, 200, 25);
		add(lengthtxt);
		
		JLabel weightlbl = new JLabel("Parcel Weight");
		weightlbl.setBounds(500, 195, 180, 25);
		add(weightlbl);

		weighttxt = new JTextField(20);
		weighttxt.setBounds(670, 195, 200, 25);
		add(weighttxt);
		
		JLabel specialReqslbl = new JLabel("Special Requirements");
		specialReqslbl.setBounds(500, 225, 180, 25);
		add(specialReqslbl);
		
		specialReqs = new JComboBox<String>();
		for (int i = 0; i < 5; i++)
			specialReqs.addItem(requirements[i]);
		specialReqs.setBounds(670, 225, 200, 25);
		add(specialReqs);
		
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.setBounds(160, 425, 150, 25);
		add(purchaseButton);
		purchaseButton.addActionListener(this);
		purchaseButton.setActionCommand("purchase");
		
		JButton parcelButton = new JButton("Add Parcel");
		parcelButton.setBounds(575, 290, 150, 25);
		add(parcelButton);
		parcelButton.addActionListener(this);
		parcelButton.setActionCommand("parcel");
		
		JLabel parcelslbl = new JLabel("Parcels added to order:");
		parcelslbl.setBounds(525, 330, 180, 25);
		add(parcelslbl);
		
		parcels = new JTextArea("no parcels added");
		JScrollPane pane = new JScrollPane(parcels);
		pane.setBounds(525, 355, 300, 145);
		parcels.setEditable(false);
		add(pane);
	  
  }

public void actionPerformed(ActionEvent evt) {
	  if ("purchase".equals(evt.getActionCommand())) {
		  if (l.size() != 0 && (!(collectiontxt.getText().equals(""))) && (!(receipientNametxt.getText().equals(""))) && (!(receipientAddrtxt.getText().equals(""))) && (!(receipientPhonetxt.getText().equals("")))){
			  double cost = c.getDeliveryCost(l, deliveryOptions.getSelectedIndex());
			  cust.purchaseService(l, cost, deliveryOptions.getSelectedIndex(), man, new Person(receipientNametxt.getText(), receipientNametxt.getText(), null, null, receipientAddrtxt.getText(), receipientPhonetxt.getText()));
			  System.out.println(collectiontxt.getText());
			  
			  collectiontxt.setText(null);
			  receipientNametxt.setText(null);
			  receipientAddrtxt.setText(null);
			  receipientPhonetxt.setText(null);
		  }
		  else
			  JOptionPane.showMessageDialog(null, "All fields must be filled in and at least one parcel must be added to the order before it can be purchased");
	    }else if ("parcel".equals(evt.getActionCommand())){
	    	if ((!(descriptiontxt.getText().equals(""))) && (!(lengthtxt.getText().equals(""))) && (!(widthtxt.getText().equals(""))) && (!(heighttxt.getText().equals(""))) && (!(weighttxt.getText().equals("")))){
	    		String parcelstext = "";
	    		int dims[] = {Integer.parseInt(lengthtxt.getText()), Integer.parseInt(widthtxt.getText()), Integer.parseInt(heighttxt.getText())};
	    		Parcel p1 = new Parcel(descriptiontxt.getText(), 01, dims, Integer.parseInt(weighttxt.getText()), requirements[specialReqs.getSelectedIndex()], 1);
	    		l.add(p1);
	    		for (int i = 0; i < l.size(); i++){
	    			parcelstext += l.get(i).getDescription() + "\n";
	    		}
	    		parcels.setText(parcelstext);
	    		descriptiontxt.setText(null);
	    		lengthtxt.setText(null);
	    		widthtxt.setText(null);
	    		heighttxt.setText(null);
	    		weighttxt.setText(null);
	    		double cost = c.getDeliveryCost(l, deliveryOptions.getSelectedIndex());
	    		costtxt.setText("\u20ac" + cost);
	    	}
	    	else
	    		JOptionPane.showMessageDialog(null, "Parcel details must be provided");
	    }else 
	    {
	        System.exit(0);
	    }
  }
}