package Report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Works.Order;

public class Report extends ReportComponent {

	private int reportId;
	private Order order;
	private String deliverStatus;
	private String deliverTime;
	private String customerFeedback;
	private int numOfDispatches;
	//private List<Courier> couriers;
	private String customerSignature;
	private String courierSignature;
	private String managerSignature;
	private String recipientSignature;
	
	public Report(Order O) {
		reportId = 1;
		this.order = O;
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
	
	public String getCourierSignature() {
		return courierSignature;
	}

	public void setCourierSignature(String courierSignature) {
		this.courierSignature = courierSignature;
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

	@Override
	public void prtReport() {
		// TODO Auto-generated method stub
		try(FileWriter fw = new FileWriter("printable_Delivery_Report.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println("DELIVERY REPORT");
			    out.println();
			    out.println("Report ID: " + this.reportId);
			    out.println("Delivery Status: " + this.deliverStatus);
			    out.println("Delivery Time: ");
			    out.println("Number of Dispatches: " + this.numOfDispatches);
			    out.println("Customer Name: ");
			    out.println("Customer Signature: " + this.customerSignature);
			    out.println("CourierName: ");
			    out.println("Courier Signiture: " + this.courierSignature);
			    out.println("Recipient Name: ");
			    out.println("Recipient Signature: " + this.recipientSignature);
			    out.println("Manager Name: ");
			    out.println("Manager Signature: " + this.managerSignature);
			    out.println();
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	/*public void addCourier(Courier courier){
		couriers.add(courier);
	}*/
	
	
	
}
