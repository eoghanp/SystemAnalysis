package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ManagerUI extends JPanel implements ActionListener {
	
	public ManagerUI() {
		setLayout(null);
		
		Object[][] cellData = { { "OrderID", "Customer", "Priority", "Parcels", "Collection", "Delivery" }, { "2-1", "2-2", "3", "4", "5", "6" } };
	    String[] columnNames = { "OrderID", "Customer", "Priority", "Parcels", "Collection", "Delivery" };

	    JTable table = new JTable(cellData, columnNames);
	    JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 50, 450, 150);
	    add(pane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
