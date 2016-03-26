package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Users.Manager;
import Works.Order;
import data.Calculator;
import route.Route;

public class AssignCourierUI extends JPanel implements ActionListener {
	
	protected JComboBox<String> availableCouriers;
	protected JTable table;
	
	public AssignCourierUI(Manager manager) {
		setLayout(null);
		Calculator calc = new Calculator();
		List<Route> routes = calc.calculateRoutes(manager.getListOfOrders());
		
		String[][] cellData = new String[routes.size()][5];
		for(int i = 0; i < routes.size(); i++){
			cellData[i][0] = "" + routes.get(i).getRouteId();
			cellData[i][1] = "" + routes.get(i).getRouteDetails();
			cellData[i][2] = "" + routes.get(i).getDistance();
			cellData[i][3] = "" + routes.get(i).getVehicle();
			cellData[i][4] = "" + routes.get(i).getJobs().size();
		}
			
	    String[] columnNames = { "RouteID", "Description", "Distance", "Vehicle", "Number of Jobs"};

	    table = new JTable(cellData, columnNames);
	    JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 50, 450, 150);
	    add(pane);
	    
	    availableCouriers = new JComboBox<String>();
		for (int i = 0; i < manager.getListOfCouriers().length; i++)
			availableCouriers.addItem(manager.getListOfCouriers()[i].getName());
		availableCouriers.setBounds(180, 530, 200, 25);
		add(availableCouriers);
		
		JButton assignButton = new JButton("Assign Route");
		assignButton.setBounds(100, 530, 150, 25);
		add(assignButton);
		assignButton.addActionListener(this);
		assignButton.setActionCommand("assign");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("assign" == e.getActionCommand()){
			System.out.println(availableCouriers.getSelectedIndex() + " & " + table.getSelectedRow());
		}
		
	}

}
