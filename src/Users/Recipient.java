package Users;

public interface Recipient {
	/** @param fname cannot be null and must be a String
	 * 
	 * @pre @param fname != null
	 */
	public void setFirstName(String fname);
	public void setLastName(String lname);
	public void setAddress(String newAddress);
	public void setTelephone(String newTelephone);
	public String trackDelivery();
	/** name cannot be null
	 * 
	 * @post @return name != null
	 */
	public String getName();
	public String getAddress();
	public String getTelephone();
}
