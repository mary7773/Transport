package transporting;

import java.util.Random;

//import java.util.UUID;

public abstract class TransportAbstract implements TransportInterface {

	protected String identifier;
	protected String manufacturer;
	protected String model;
	protected int year;
	protected String owner;


	public String getIdentifier() {
		// String identifier = UUID.randomUUID().toString();
		// return identifier;

		String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(4);
		for (int i = 0; i < 4; i++)
			sb.append(characters.charAt(rnd.nextInt(characters.length())));
		return sb.toString();

	}

	@Override
	public void printInfo() {
		System.out.println("The model is: \t\t" + this.model);
		System.out.println("The type is: \t\t" + this.getType());
		System.out.println("The year is: \t\t" + this.year);
		System.out.println("The owner is: \t\t" + this.owner);
		System.out.println("The vehicle is: \t" + this.getName());
	}

}
