package Users;

public interface Recipient {
	/** @param fname cannot be null and must be a String
	 * 
	 *  @pre fname != null
	 */
	public void setFirstName(String fname);
	/** @param lname cannot be null and must be a String
	 * 
	 *  @pre lname != null
	 */
	public void setLastName(String lname);
	/** @param address cannot be null and must be a String
	 * 
	 *  @pre newAddress != null
	 */
	public void setAddress(String newAddress);
	/** @param newTelephone cannot be null and must be a String
	 * 
	 *  @pre newTelephone != null 
	 */
	public void setTelephone(String newTelephone);
	public String trackDelivery();
	/** name cannot be null
	 * 
	 * @post @return name != null
	 */
	public String getName();
	/** address cannot be null
	 * 
	 * @post @return address != null
	 */
	public String getAddress();
	/** telephone cannot be null
	 * 
	 * @post @return telephone != null
	 */
	public String getTelephone();
}
