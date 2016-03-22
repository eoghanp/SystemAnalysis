package UI;

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


	public abstract int sendBackJob();

	public abstract int sendForwardJob();

	public abstract String getJobStatus();

}