package calculator;

import java.util.List;

import route.Route;

public class RoutingAlgorithm2 extends Thread implements RoutingInterface{

	public RoutingAlgorithm2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void generateRoutes() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			System.out.println("Routing Algorithm 2");
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void run(){
		generateRoutes();
	}

}
