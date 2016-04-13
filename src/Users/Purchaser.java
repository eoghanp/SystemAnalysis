package Users;

import java.util.List;

import data.Parcel;

public interface Purchaser {
	public String specifyDetails();
	public void enquireAboutService();
	public void purchaseService(List<Parcel> parcels, double cost, int priority, Manager man, Person person);
	public int getCardNumber();
}
