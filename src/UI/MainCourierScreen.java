package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Vehicle.Vehicle;
import route.Route;

public class MainCourierScreen extends JPanel implements ActionListener{

	public MainCourierScreen() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JButton viewRouteButton = new JButton("View Route/Jobs");
		viewRouteButton.setBounds(300, 230, 150, 25);
		add(viewRouteButton);
		viewRouteButton.addActionListener(this);
		viewRouteButton.setActionCommand("View route");
		
		JButton signButton = new JButton("Update Location");
		signButton.setBounds(20, 230, 150, 25);
		add(signButton);
		signButton.addActionListener(this);
		signButton.setActionCommand("Sign off");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if ("Sign off".equals(e.getActionCommand())) 
		{
			Route aRoute = new Route(0, "null");
			Vehicle aVehicle = new Vehicle("null",0.0,null,null,null);
			aVehicle.registerObserver(aRoute);
			aVehicle.setLocation("Limerick");
			aVehicle.setLocation("Offaly");
		}
		
	}

}
