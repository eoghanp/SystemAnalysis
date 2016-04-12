package Report;

import java.util.ArrayList;
import java.util.List;

import Works.Order;

public class Report {

	private Order order;
	private String deliverStatus;
	private String deliverTime;
	private String customerFeedback;
	private int numOfDispatches;
	//private List<Courier> couriers;
	private String customerSignature;
	private String managerSignature;
	private String recipientSignature;
	
	public Report() {
		//couriers = new ArrayList<>();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getDeliverStatus() {
		return deliverStatus;
	}

	public void setDeliverStatus(String deliverStatus) {
		this.deliverStatus = deliverStatus;
	}

	public String getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public int getNumOfDispatches() {
		return numOfDispatches;
	}

	public void setNumOfDispatches(int numOfDispatches) {
		this.numOfDispatches = numOfDispatches;
	}

	/*public List<Courier> getCouriers() {
		return couriers;
	}

	public void setCouriers(List<Courier> couriers) {
		this.couriers = couriers;
	}
*/
	public String getCustomerSignature() {
		return customerSignature;
	}

	public void setCustomerSignature(String customerSignature) {
		this.customerSignature = customerSignature;
	}

	

	public String getManagerSignature() {
		return managerSignature;
	}

	public void setManagerSignature(String managerSignature) {
		this.managerSignature = managerSignature;
	}

	public String getRecipientSignature() {
		return recipientSignature;
	}

	public void setRecipientSignature(String recipientSignature) {
		this.recipientSignature = recipientSignature;
	}
	
	/*public void addCourier(Courier courier){
		couriers.add(courier);
	}*/
	
	
	
}
