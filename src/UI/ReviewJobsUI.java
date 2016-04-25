package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Report.Report;
import Users.Manager;
import Works.Job;
import Works.Order;
import dataIO.DBHandler;
import route.Route;

public class ReviewJobsUI extends JPanel implements ActionListener{

	protected List<Order> jobs;
	private JTable table;
	private Manager man;
	
	public ReviewJobsUI(Manager manager) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		man = manager;
		
		JLabel mainlbl = new JLabel("Jobs:");
		mainlbl.setBounds(250, 10, 150, 25);
		add(mainlbl);
		
		DBHandler db = DBHandler.getSingletonInstance();
		try {
			
			jobs = db.getOrder();
			
			String[][] cellData = new String[jobs.size()][5];;
			for(int i = 0; i < jobs.size(); i++){
				cellData[i][0] = "" + jobs.get(i).getOrderID();
				cellData[i][1] = "" + jobs.get(i).getReport().getCustomerSignature();
				cellData[i][2] = "" + jobs.get(i).getReport().getCourierSignature();
				cellData[i][3] = "" + jobs.get(i).getStatus();
				cellData[i][4] = "" + jobs.get(i).getRecipient().getName();
			}
			
			String[] columnNames = { "OrderID", "Customer", "Courier", "Status", "Recipient"};

			DefaultTableModel model = new DefaultTableModel(cellData, columnNames);
	    
			table = new JTable(model);
			JScrollPane pane = new JScrollPane(table);
			pane.setBounds(10, 50, 525, 185);
			add(pane);
			
			JButton signOffButton = new JButton("Sign off on job");
			signOffButton.setBounds(10, 275, 150, 25);
			add(signOffButton);
			signOffButton.addActionListener(this);
			signOffButton.setActionCommand("sign off");
			
			JButton dispatchButton = new JButton("Dispatch job again");
			dispatchButton.setBounds(170, 275, 150, 25);
			add(dispatchButton);
			dispatchButton.addActionListener(this);
			dispatchButton.setActionCommand("dispatch");
			
			JButton reportButton = new JButton("Print Report");
			reportButton.setBounds(330, 275, 150, 25);
			add(reportButton);
			reportButton.addActionListener(this);
			reportButton.setActionCommand("print");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (table.getSelectedRow() >= 0){
			Report rep = jobs.get(table.getSelectedRow()).getReport();
			if ("sign off" == e.getActionCommand()){
				rep.setManagerSignature(man.getName());
				rep.setDeliverStatus("Delivery completed and verified by manager");
			}
			else if ("dispatch" == e.getActionCommand()){
				
			}
			else if ("print" == e.getActionCommand()){
				try {
					man.printReport(jobs.get(table.getSelectedRow()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}

}
