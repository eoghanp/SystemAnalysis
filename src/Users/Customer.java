package Users;

import java.util.List;

import parcel.Parcel;

public interface Customer {
	public String specifyDetails();
	public void purchaseService(List<Parcel> parcels, double cost, int priority, Manager man, Person person, String string);
	public int getCardNumber();
}
