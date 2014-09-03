package transporting;

public interface TransportInterface {
	public void printInfo();
	public String getType();
	public String getManufacturer();
	public String getModel();
	public int getYearOfProduction();
	public String getOwner();
	public String getName();
	public String getIdentifier();
	public void setYear(int year);
	public void setOwner(String owner);
	public void setManufacturer(String manufacturer);
	public void setModel(String model);
	
	

}
