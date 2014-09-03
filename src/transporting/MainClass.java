package transporting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		List<TransportInterface> database = new ArrayList<TransportInterface>();

		Car car;
		Bus bus;
		Truck truck;
		Motorbike motorbike;
		Bike bike;
		Plane plane;
		Shuttle shuttle;
		Balloon balloon;
		Ship ship;
		MotorBoat motorboat;
		WindSurf windsurf;
		Boat boat;

		car = new Car("BMW", "M1", 2012, "Gabi");
		database.add(car);

		bus = new Bus("Iveco", "370", 1999, "Iveco");
		database.add(bus);

		truck = new Truck("Mercedes-BenzMercedes-Benz", "Actros", 2013,
				"Mercedes");
		database.add(truck);

		motorbike = new Motorbike("Suzuki", "S2", 2011, "Atanas");
		database.add(motorbike);

		bike = new Bike("Sport", "NM", 1998, "Nina");
		database.add(bike);

		shuttle = new Shuttle("Space", "CM", 2009, "NASA");
		database.add(shuttle);

		balloon = new Balloon("Air", "AI", 2008, "Training academy");
		database.add(balloon);

		plane = new Plane("Aircraf", "A27", 2003, "Airs");
		database.add(plane);

		ship = new Ship("Carnival", "Cruise ship", 1995,
				"Carnival cruise lines");
		database.add(ship);

		motorboat = new MotorBoat("Yacht", "Serena", 2013, "Anna");
		database.add(motorboat);

		windsurf = new WindSurf("Surf company", "SF", 2002, "Viki");
		database.add(windsurf);

		boat = new Boat("Boat company", "B4", 2001, "Pesho");
		database.add(boat);

		makeChoise(database);
	}

	// Edit info in database
	private static void editInfo(List<TransportInterface> database,
			ArrayList<TransportInterface> tempList) {

		searchIn(database, tempList);

		int index = -1;

		for (TransportInterface t : tempList) {
			t.printInfo();
			index = database.indexOf(t);
			System.out.println(index);
		}

		if (index != -1) {
			Scanner in = new Scanner(System.in);

			Scanner input = new Scanner(System.in);
			System.out.println("Enter the name of the vehicle: ");
			String name = input.nextLine();

			System.out.println("Modify the manufacturer: ");
			String manufacturer = input.nextLine();

			System.out.println("Modify the model: ");
			String model = input.nextLine();

			System.out.println("Modify the owner: ");
			String owner = input.nextLine();

			System.out.println("Modify the year: ");
			String y = input.nextLine();
			int year = Integer.parseInt(y);

			if (name.equals("Car")) {
				database.set(index, new Car(manufacturer, model, year, owner));
			}
	
			if (name.equals("Truck")) {
				database.add(new Truck(manufacturer, model, year, owner));
			}
			if (name.equals("Bus")) {
				database.add(new Bus(manufacturer, model, year, owner));
			}
			if (name.equals("Motorbike")) {
				database.add(new Motorbike(manufacturer, model, year, owner));
			}
			if (name.equals("Ship")) {
				database.add(new Ship(manufacturer, model, year, owner));
			}
			if (name.equals("Boat")) {
				database.add(new Boat(manufacturer, model, year, owner));
			}
			if (name.equals("Skateboard")) {
				 database.add( new Skateboard(manufacturer, model, year, owner));
			}
			if (name.equals("Shuttle")) {
				 database.add( new Shuttle(manufacturer, model, year, owner));
			}
			if (name.equals("Windsurf")) {
				 database.add( new WindSurf(manufacturer, model, year, owner));
			}
			
		}
	}// end edit

	// print database info
	private static void showDatabase(List<TransportInterface> database) {
		Iterator<TransportInterface> it = database.iterator();

		while (it.hasNext()) {
			TransportInterface transport = it.next();
			transport.printInfo();
			System.out.println("====================================");
		}
	}// end print

	// Delete vehicle from database
	private static void delete(List<TransportInterface> database, String model) {
		ArrayList<TransportInterface> temp = new ArrayList<TransportInterface>();
		Iterator<TransportInterface> it = database.iterator();
		while (it.hasNext()) {
			TransportInterface tr = it.next();
			if (tr.getModel().equals(model)) {
				it.remove();
			}
		}
	}// end delete

	// Add vehicle method
	private static void add(List<TransportInterface> database, int key) {
		Scanner in = new Scanner(System.in);
		System.out
				.println("Enter to add: 1 - car, 2 - bus, 3 - truck, 4 - motorbike,\n"
						+ " 5 - bike, 6 - plane, 7 - shuttle, 8 - ballon, 9 - ship,\n "
						+ " 10 - motorboat, 11 - wndsurf, 12 - boat");

		key = in.nextInt();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the manufacturer: ");
		String manufacturer = input.nextLine();

		System.out.println("Enter the model: ");
		String model = input.nextLine();

		System.out.println("Enter the owner: ");
		String owner = input.nextLine();

		System.out.println("Enter the year: ");
		String y = input.nextLine();
		int year = Integer.parseInt(y);

		switch (key) {
		case 1:
			TransportInterface transport = new Car(manufacturer, model, year,
					owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 2:
			transport = new Bus(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 3:
			transport = new Truck(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 4:
			transport = new Motorbike(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 5:
			transport = new Bike(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 6:
			transport = new Plane(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 7:
			transport = new Shuttle(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 8:
			transport = new Balloon(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 9:
			transport = new Ship(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 10:
			transport = new MotorBoat(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 11:
			transport = new WindSurf(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;
		case 12:
			transport = new Boat(manufacturer, model, year, owner);
			database.add(transport);
			System.out.println("The vehicle is added to the database!");
			break;

		}
	}// end add vihecle

	// Search vehicle method
	private static void searchIn(List<TransportInterface> database,
			List<TransportInterface> tempList) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the model of the vehicle for searching: ");
		String transport = input.nextLine();

		for (TransportInterface d : database) {
			if (d.getModel().equals(transport)) {
				tempList.add(d);
			}
		}

		for (TransportInterface trans : tempList) {
			trans.printInfo();
			System.out.println("====================================");
		}

	}// end search method

	// make choise method
	private static void makeChoise(List<TransportInterface> database) {

		int choice = 0;

		while (choice < 9) {

			choice = menu();

			switch (choice) {
			case 1:
				showDatabase(database);
				break;

			case 2:
				List<TransportInterface> tempList = new ArrayList<TransportInterface>();
				searchIn(database, tempList);
				break;

			case 3:
				int key = 0;
				add(database, key);
				break;

			case 4:
				Scanner input = new Scanner(System.in);
				System.out
						.println("Enter the model of the vehicle for deleteing: ");
				String model = input.nextLine();
				delete(database, model);
				break;

			case 5:
				ArrayList<TransportInterface> temp = new ArrayList<TransportInterface>();
				editInfo(database, temp);
				break;
			case 6:
				ComporatorById compare = new ComporatorById();
				 Collections.sort(database, compare);
				break;
			case 7:
				ComparatorByType compareType = new ComparatorByType();
				Collections.sort(database, compareType);
				break;
			case 8:				
				 Collections.shuffle(database);
				break;
			case 9:
				System.out.println("Bye!");
				break;
			}
		}
	}// end makeChoise method

	private static int menu() {

		System.out.println("\t1. Show the list of transport\t");
		System.out.println("\t2. Search a vehicle\t");
		System.out.println("\t3. Add a vehicle\t");
		System.out.println("\t4. Delete a vehicle\t");
		System.out.println("\t5. Edit a vehicle\t");
		System.out.println("\t6. Sort by identifier vehicles\t");
		System.out.println("\t7. Sort by type vehicles\t");
		System.out.println("\t8. Shuffle vehicles\t");
		System.out.println("\t9. Exit the system\t");
		System.out.println("====================================");

		try {
			while (true) {
				System.out.println("Choose an option: ");
				Scanner input = new Scanner(System.in);
				int choice = input.nextInt();
				// input.close();
				return choice;
			}

		} catch (Exception e) {
			System.err.println("Wrong choise " + e.getMessage());
		}
		return 0;
	}// end menu

}
