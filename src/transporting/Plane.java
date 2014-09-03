package transporting;

public class Plane extends AirMotorVihecle {

	public Plane(String manufacturer, String model, int year, String owner) {
		this.manufacturer = manufacturer;
		this.year = year;
		this.model = model;
		this.owner = owner;
	}

	@Override
	public void setYear(int year) {
		this.year = year;

	}

	@Override
	public void setOwner(String owner) {
		this.owner = owner;

	}

	@Override
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;

	}

	@Override
	public void setModel(String model) {
		this.model = model;

	}

	@Override
	public String getName() {
		return "Plane";
	}

	public void printInfo() {
		System.out
				.println("The identification number is: \t" + getIdentifier());
		super.printInfo();
	}

	@Override
	public String getManufacturer() {

		return this.manufacturer;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public int getYearOfProduction() {
		return this.year;
	}

	@Override
	public String getOwner() {
		return this.owner;
	}

}
