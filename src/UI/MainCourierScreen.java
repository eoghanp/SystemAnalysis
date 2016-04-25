package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Users.Courier;
import Vehicle.SmallVan;
import Works.Job;
import route.Route;

public class MainCourierScreen extends JPanel implements ActionListener{

	protected List<Job> jobs;
	private JTable table;
	private enum status {withCustomer, withCourier, delivered};
	
	public MainCourierScreen(Courier courier) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		courier.getSchedule();
		Route route = courier.getRoute();
		if (route != null){
			jobs = route.getJobs();
		
			String[][] cellData = new String[jobs.size()][6];;
			for(int i = 0; i < jobs.size(); i++){
				cellData[i][0] = "" + jobs.get(i).getOrderID();
				cellData[i][1] = "";
				cellData[i][2] = "" + jobs.get(i).getCollectionAddress();
				cellData[i][3] = "" + jobs.get(i).getRecipient().getName();
				cellData[i][4] = "" + jobs.get(i).getRecipient().getAddress();
				cellData[i][5] = "" + jobs.get(i).getRecipient().getTelephone();
			}
			
			String[] columnNames = { "OrderID", "Number of Parcels", "Collection Address", "Recipient Name", "Delivery Address", "Phone Number"};

			DefaultTableModel model = new DefaultTableModel(cellData, columnNames);
	    
			table = new JTable(model);
			JScrollPane pane = new JScrollPane(table);
			pane.setBounds(10, 50, 525, 185);
			add(pane);
			
			JButton statusButton = new JButton("Sign for");
			statusButton.setBounds(300, 275, 150, 25);
			add(statusButton);
			statusButton.addActionListener(this);
			statusButton.setActionCommand("Sign");
		}
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(table.getSelectedRow() >= 0)
			if ("Sign".equals(e.getActionCommand())) 
			{
				jobs.get(table.getSelectedRow()).setStatus();
				JOptionPane.showMessageDialog(null, "Signed for order " + jobs.get(table.getSelectedRow()).getOrderID() + "\n" + jobs.get(table.getSelectedRow()).getStatus());
			}
		
	}

}
