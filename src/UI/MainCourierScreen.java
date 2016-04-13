package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainCourierScreen extends JPanel implements ActionListener{

	public MainCourierScreen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setLayout(null);
		
		JButton viewRouteButton = new JButton("View Route/Jobs");
		viewRouteButton.setBounds(300, 230, 150, 25);
		add(viewRouteButton);
		viewRouteButton.addActionListener(this);
		viewRouteButton.setActionCommand("View route");
		
		JButton signButton = new JButton("Sign off on Delivery");
		signButton.setBounds(20, 230, 150, 25);
		add(signButton);
		signButton.addActionListener(this);
		signButton.setActionCommand("Sign off");
		
	}

}
