package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Users.Courier;
import Users.Manager;
import calculator.Calculator;
import dataIO.DBHandler;
import route.Route;

public class AssignCourierUI extends JPanel implements ActionListener {
	
	protected JComboBox<String> availableCouriers;
	protected JTable table;
	protected JScrollPane pane;
	protected Manager man;
	protected List<Route> routes;
	protected List<Courier> courierList;
	protected JTextArea assigned;
	protected String assignedTxt;
	
	public AssignCourierUI(Manager manager) {
		setLayout(null);
		Calculator calc = new Calculator();
		man = manager;
		courierList = man.getListOfCouriers();
		routes = calc.calculateRoutes(man.getListOfOrders());
		populateTable();
		assignedTxt = "";
	    
	    JLabel routesTablelbl = new JLabel("Routes to be assigned:");
	    routesTablelbl.setBounds(10, 10, 180, 25);
		add(routesTablelbl);
		
		JLabel selectCourierlbl = new JLabel("Available Couriers:");
		selectCourierlbl.setBounds(20, 250, 180, 25);
		add(selectCourierlbl);
	    
		JButton assignButton = new JButton("Assign Route");
		assignButton.setBounds(300, 275, 150, 25);
		add(assignButton);
		assignButton.addActionListener(this);
		assignButton.setActionCommand("assign");
		
		JLabel routesAssignedlbl = new JLabel("Routes Assigned:");
		routesAssignedlbl.setBounds(100, 345, 180, 25);
		add(routesAssignedlbl);
		
		assigned = new JTextArea("nothing assigned yet");
		JScrollPane pane = new JScrollPane(assigned);
		pane.setBounds(100, 375, 300, 175);
		assigned.setEditable(false);
		add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("assign" == e.getActionCommand()){
			if (availableCouriers.getSelectedIndex() >= 0 && table.getSelectedRow() >= 0){
				int a = availableCouriers.getSelectedIndex(), b = table.getSelectedRow();
				courierList.get(a).setRoute(routes.get(b));
				DBHandler db = DBHandler.getSingletonInstance();
				db.assignRoute(courierList.get(a).getCourierID(), routes.get(b).getRouteId());
				assignedTxt += routes.get(b).getRouteId() + ": " + routes.get(b).getRouteDetails() + " assigned to " + courierList.get(a).getName() + "\n";
				availableCouriers.removeItemAt(a);
				((DefaultTableModel)table.getModel()).removeRow(b);
				courierList.remove(a);
				assigned.setText(assignedTxt);
			}
		}
		
	}
	
	public void populateTable(){
		String[][] cellData = new String[routes.size()][5];;
		for(int i = 0; i < routes.size(); i++){
			cellData[i][0] = "" + routes.get(i).getRouteId();
			cellData[i][1] = "" + routes.get(i).getRouteDetails();
			cellData[i][2] = "" + routes.get(i).getDistance();
			cellData[i][3] = "" + routes.get(i).getVehicle().getModel();
			cellData[i][4] = "" + routes.get(i).getJobs().size();
		}
			
	    String[] columnNames = { "RouteID", "Description", "Distance", "Vehicle", "Number of Jobs"};

	    DefaultTableModel model = new DefaultTableModel(cellData, columnNames);
	    
	    table = new JTable(model);
	    pane = new JScrollPane(table);
		pane.setBounds(10, 50, 525, 185);
	    add(pane);
	    
	    availableCouriers = new JComboBox<String>();
		for (int i = 0; i < courierList.size(); i++)
			availableCouriers.addItem(courierList.get(i).getName());
		availableCouriers.setBounds(20, 275, 200, 25);
		add(availableCouriers);
	}

}
