package parcel;

public class Parcel {

private String description;
private int parcelID;
private int[] dimensions;  //Length, Width, Height
private double weight;
private String specialRequirements;
private int urgency;
 
//constructor to create a parcel
public Parcel(String desc, int parcelID, int[] dimensions, double weight, String specialRequirements, int urgency) {
this.description = desc;
this.parcelID = parcelID;
this.dimensions = dimensions;
this.weight = weight;
this.specialRequirements = specialRequirements;
this.urgency = urgency;
}

public void setDescription(String desc){
	this.description = desc;
}

public String getDescription(){
	return this.description;
}

public int[] getDimensions() {
	return dimensions;
}

public void setDimensions(int[] dimensions) {
	this.dimensions = dimensions;
}

public double getWeight() {
	return weight;
}

public void setWeight(double weight) {
	this.weight = weight;
}

public String getSpecialRequirements() {
	return specialRequirements;
}

public void setSpecialRequirements(String specialRequirements) {
	this.specialRequirements = specialRequirements;
}

public int getUrgency() {
	return urgency;
}

public void setUrgency(int urgency) {
	this.urgency = urgency;
}

public int getParcelID() {
	return parcelID;
}
 
 
}
