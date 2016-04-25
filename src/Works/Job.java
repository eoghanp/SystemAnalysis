package Works;

import Users.Recipient;
import Works.Order.Status;

public interface Job
{
	public Recipient getRecipient();
	
	public int getPriority();
	
	public void setStatus();
	
	public Status getStatus();
	
	public String getCollectionAddress();
	
	public int getOrderID();

}