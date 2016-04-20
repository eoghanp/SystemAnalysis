package Works;

import Users.Recipient;

public interface Job
{

	//public abstract int sendBackJob();

	//public abstract int sendForwardJob();

	//public abstract String getJobStatus();
	
	public Recipient getRecipient();
	
	public int getPriority();
	
	public void setStatus(int newStatus);
	
	public int getStatus();
	
	public String getCollectionAddress();

}