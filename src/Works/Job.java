package Works;

import Users.Recipient;

public interface Job
{
	/*
	private int orderID;
	private Parcel[] parcelArr;
	private Courier courier;
	private int priority;
	private String orderStatus;
	private String recipientDetails;
	*/


	//public abstract int sendBackJob();

	//public abstract int sendForwardJob();

	//public abstract String getJobStatus();
	
	public Recipient getRecipient();
	
	public int getPriority();
	
	public void setStatus(int newStatus);
	
	public int getStatus();

}