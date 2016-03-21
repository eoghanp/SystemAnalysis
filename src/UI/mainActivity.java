package UI;

import java.util.*;

import Users.Customer;
import data.Parcel;

public class mainActivity {

	public static void main(String[] args) {
		Customer customer = new Customer(null, null, null, null, null, null, 0, 0);
		int dims[] = {10, 5, 5};
		Parcel p = new Parcel(01, dims, 20, "none", 1);
		List<Parcel> l = new ArrayList<Parcel>();
		l.add(p);
		customer.purchaseService(l);

	}
	
}
