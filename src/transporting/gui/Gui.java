package transporting.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import javax.swing.table.TableRowSorter;
import javax.xml.ws.handler.MessageContext;

import transporting.Balloon;
import transporting.Bike;
import transporting.Boat;
import transporting.Bus;
import transporting.Car;
import transporting.ComparatorByType;
import transporting.ComporatorById;
import transporting.MotorBoat;
import transporting.Motorbike;
import transporting.Plane;
import transporting.Ship;
import transporting.Shuttle;
import transporting.Skateboard;
import transporting.TransportAbstract;
import transporting.TransportInterface;
import transporting.Truck;
import transporting.WindSurf;

public class Gui extends JFrame {

	List<TransportInterface> data;

	JComboBox<String> vehicles = null;
	JComboBox<String> kind = null;
	int index = -1;

	JFrame myFrame = new JFrame("Transport Software");

	/*--------------Dialog-----------------*/
	JDialog dialog;
	JDialog searchDialog;
	JDialog showDialog;
	JDialog editDialog;

	/*--------------Labels-----------------*/
	// JLabel labelAdd = new JLabel("*Add vehicle");
	// JLabel labelSearch = new JLabel("*Search vehicle");
	// JLabel labelDelete = new JLabel("*Delete vehicle");
	// JLabel labelSort = new JLabel("*Sort vehicles");
	// JLabel labelShuffle = new JLabel("*Shuffle vehicles");
	// JLabel labelTable = new JLabel("Table with vehicles");

	/*--------------Buttons-----------------*/
	JButton add = new JButton("Add vehicle");
	JButton search = new JButton("Search vehicle");
	JButton delete = new JButton("Delete vehicle");
	JButton sort = new JButton("Sort vehicles");
	JButton shuffle = new JButton("Shuffle vehicles");
	JButton edit = new JButton("Edit vehicle");
	JButton exit = new JButton("Exit the system");

	JTable table;
	TransportTableModel model;

	public Gui() {
		this.data = createDatabase();
		myFrame.setVisible(true);
		myFrame.setSize(500, 600);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makePanel(myFrame);
	}// end constructor

	public void makePanel(JFrame myFrame2) {

		final JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createParallelGroup()
				.addComponent(add).addComponent(sort).addComponent(delete)
				.addComponent(edit).addComponent(shuffle).addComponent(search));

		table = createTable(model);
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.add(exit);
		myFrame2.add(panel);

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				editInfo();
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addInfo(table);
			}
		});

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				search(table);
			}
		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					deleteRow();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(panel,
							"Select the row that you want to delete!");
				}

			}
		});

		sort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ComporatorById comp = new ComporatorById();

				Collections.sort(data, comp);
				((TransportTableModel) table.getModel()).fireTableDataChanged();

			}
		});

		shuffle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(data);
				((TransportTableModel) table.getModel()).fireTableDataChanged();
			}
		});

	}// end makePanel()

	private JTable createTable(TransportTableModel model2) {

		model2 = new TransportTableModel(this.data);
		table = new JTable(model2);
		table.setLayout(new BorderLayout());
		table.getColumnModel();
		model2.getColumnName(model2.getColumnCount() - 1);
		table.setRowSorter(new TableRowSorter<TransportTableModel>(model2));
		// table.setAutoscrolls(true);
		// table.setColumnSelectionAllowed(true);
		table.setFocusable(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return table;
	}

	private List<TransportInterface> createDatabase() {

		List<TransportInterface> data = new ArrayList<TransportInterface>();
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
		data.add(car);

		bus = new Bus("Iveco", "370", 1999, "Iveco");
		data.add(bus);

		truck = new Truck("Mercedes-BenzMercedes-Benz", "Actros", 2013,
				"Mercedes");
		data.add(truck);

		motorbike = new Motorbike("Suzuki", "S2", 2011, "Atanas");
		data.add(motorbike);

		bike = new Bike("Sport", "NM", 1998, "Nina");
		data.add(bike);

		shuttle = new Shuttle("Space", "CM", 2009, "NASA");
		data.add(shuttle);

		balloon = new Balloon("Air", "AI", 2008, "Training academy");
		data.add(balloon);

		plane = new Plane("Aircraf", "A27", 2003, "Airs");
		data.add(plane);

		ship = new Ship("Royal", "Cruise ship", 2004, "Royal Carribean");
		data.add(ship);

		motorboat = new MotorBoat("Yacht", "Serena", 2013, "Anna");
		data.add(motorboat);

		windsurf = new WindSurf("Surf company", "SF", 2002, "Viki");
		data.add(windsurf);

		boat = new Boat("Boat company", "B4", 2001, "Pesho");
		data.add(boat);

		return data;
	}// end createDatabase()

	private void addInfo(final JTable table) {
		dialog = new JDialog(myFrame);
		dialog.setSize(260, 260);
		dialog.setTitle("Add vehicle");
		// dialog.setLayout(new GridLayout(0,2));

		final JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		// panel.setSize(240,250);

		String[] kindOfTransport = { "Land transport", "Air transport",
				"Sea transport" };

		String[] allVehicles = { "Car", "Bus", "Truck", "Motorbike", "Bike",
				"Skateboard" };

		vehicles = new JComboBox<String>(allVehicles);
		kind = new JComboBox<String>(kindOfTransport);

		kind.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (kind.getSelectedIndex() == 0) {
					vehicles.removeAllItems();
					vehicles.addItem("Car");
					vehicles.addItem("Bus");
					vehicles.addItem("Truck");
					vehicles.addItem("Motorbike");
					vehicles.addItem("Bike");
					vehicles.addItem("Skateboard");
				} else if (kind.getSelectedIndex() == 1) {
					vehicles.removeAllItems();
					vehicles.addItem("Plane");
					vehicles.addItem("Shuttle");
					vehicles.addItem("Balloon");
				} else if (kind.getSelectedIndex() == 2) {
					vehicles.removeAllItems();
					vehicles.addItem("Ship");
					vehicles.addItem("Motorboat");
					vehicles.addItem("Boat");
					vehicles.addItem("Windsurf");
				}

			}
		});

		final JTextField modelField = new JTextField(10);
		final JTextField manufacturerField = new JTextField(10);
		final JTextField ownerField = new JTextField(10);
		final JTextField yearField = new JTextField(10);

		JLabel lModel = new JLabel("*Model              ", FlowLayout.LEFT);
		JLabel lManufacturer = new JLabel("*Manufacturer", FlowLayout.LEFT);
		JLabel lOwner = new JLabel("*Owner            ", FlowLayout.LEFT);
		JLabel lYear = new JLabel("*Year               ", FlowLayout.LEFT);

		JButton saveInfo = new JButton("Save data");
		saveInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				saveData(table, modelField, manufacturerField, ownerField,
						yearField);
				dialog.setVisible(false);
				modelField.setText("Model");
				manufacturerField.setText("Manufacturer");
				ownerField.setText("Owner");
				yearField.setText("Year");
			}
		});

		panel.add(kind);
		panel.add(vehicles);
		panel.add(lModel);
		panel.add(modelField);
		panel.add(lManufacturer);
		panel.add(manufacturerField);
		panel.add(lOwner);
		panel.add(ownerField);
		panel.add(lYear);
		panel.add(yearField);
		panel.add(saveInfo);

		dialog.add(panel);
		dialog.setVisible(true);
	}

	public void saveData(final JTable table, final JTextField modelField,
			final JTextField manufacturerField, final JTextField ownerField,
			final JTextField yearField) {
		int kindIndex = kind.getSelectedIndex();
		int vehicleIndex = vehicles.getSelectedIndex();

		String model = modelField.getText();
		String manufacturer = manufacturerField.getText();
		String owner = ownerField.getText();
		int year = 0;
		try {

			String y = yearField.getText();
			year = Integer.parseInt(y);

		} catch (NumberFormatException en) {

			JOptionPane.showMessageDialog(yearField, "Year is not correct!");

		} finally {

			if (modelField.getText().isEmpty() || yearField.getText().isEmpty()
					|| manufacturerField.getText().isEmpty()
					|| ownerField.getText().isEmpty()) {

				JOptionPane.showMessageDialog(yearField, "Fill all fields!");

				// modelField.setText("Model");
				// manufacturerField.setText("Manufacturer");
				// ownerField.setText("Owner");
				// yearField.setText("Year");

			} else {

				if (kindIndex == 0) {
					switch (vehicleIndex) {
					case 0:
						data.add(new Car(manufacturer, model, year, owner));
						break;
					case 1:
						data.add(new Bus(manufacturer, model, year, owner));
						break;
					case 2:
						data.add(new Truck(manufacturer, model, year, owner));
						break;
					case 3:
						data.add(new Motorbike(manufacturer, model, year, owner));
						break;
					case 4:
						data.add(new Bike(manufacturer, model, year, owner));
						break;
					case 5:
						data.add(new Skateboard(manufacturer, model, year,
								owner));
						break;
					}
				} else if (kindIndex == 1) {
					switch (vehicleIndex) {
					case 0:
						data.add(new Plane(manufacturer, model, year, owner));
						break;
					case 1:
						data.add(new Shuttle(manufacturer, model, year, owner));
						break;
					case 2:
						data.add(new Balloon(manufacturer, model, year, owner));
						break;

					}
				} else if (kindIndex == 2) {
					switch (vehicleIndex) {
					case 0:
						data.add(new Ship(manufacturer, model, year, owner));
						break;
					case 1:
						data.add(new MotorBoat(manufacturer, model, year, owner));
						break;
					case 2:
						data.add(new Boat(manufacturer, model, year, owner));
						break;
					case 3:
						data.add(new WindSurf(manufacturer, model, year, owner));
						break;
					}
				}

			}
			((TransportTableModel) table.getModel()).fireTableDataChanged();
		}
	}

	private void search(JTable table) {
		searchDialog = new JDialog(myFrame);
		searchDialog.setSize(200, 120);
		searchDialog.setTitle("Search");
		searchDialog.setVisible(false);

		JPanel panel = new JPanel(new FlowLayout());
		JLabel modelLabel = new JLabel("*Enter model of the vehicle");
		final JTextField modelField = new JTextField(10);
		JButton search = new JButton("Search in the table");

		panel.add(modelLabel);
		panel.add(modelField);
		panel.add(search);
		searchDialog.add(panel);
		searchDialog.setVisible(true);

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				searchDialog.setVisible(false);

				String model = modelField.getText();
				showUpData(model);
			}
		});

	}

	private void showUpData(String model) {
		showDialog = new JDialog(myFrame);
		showDialog.setSize(300, 200);
		showDialog.setVisible(false);
		showDialog.setTitle("Search for: " + model);
		JPanel panel = new JPanel(new FlowLayout());
		String content = null;
		boolean isFound = true;

		for (TransportInterface d : data) {
			if (d.getModel().equalsIgnoreCase(model)) {

				content = "The Id is " + d.getIdentifier() + "\n"
						+ "The type vehicle is " + d.getType() + "\n"
						+ "The kind is " + d.getName() + "\n"
						+ "The year of production is "
						+ d.getYearOfProduction() + "\n"
						+ "The manufacturer is " + d.getManufacturer() + "\n"
						+ "The owner is " + d.getOwner();

				JTextArea text = new JTextArea(6, 20);
				text.setText(content);
				panel.add(text);
				showDialog.add(panel);
				showDialog.setVisible(true);
				isFound = false;
			}
		}
		if (isFound) {
			JOptionPane.showMessageDialog(showDialog,
					"The vehicle does not exit in database!");
		}

	}

	private void deleteRow() {
		int indexTable = table.getSelectedRow();
		int indexModel = table.convertRowIndexToModel(indexTable);
		data.remove(indexModel);
		table.getRowSorter().allRowsChanged();
		((TransportTableModel) table.getModel()).fireTableDataChanged();

	}

	private void editInfo() {
		editDialog = new JDialog();
		editDialog.setTitle("Edit information");
		editDialog.setVisible(true);
		editDialog.setSize(200, 160);
		JLabel lModel = new JLabel("*Enter the model: ");
		final JTextField modelField = new JTextField(10);
		JButton search = new JButton("Search");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(lModel);
		panel.add(modelField);
		panel.add(search);
		editDialog.add(panel);

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				searchInDatabase(modelField.getText(), table);

			}
		});
	}

	private void searchInDatabase(String model, final JTable table) {
		final JDialog showInfo = new JDialog();
		showInfo.setSize(250, 220);
		showInfo.setTitle("Edit fields");

		JLabel lModel = new JLabel("*Model			", FlowLayout.LEFT);
		JLabel lManufacturer = new JLabel("*Manufacturer", FlowLayout.LEFT);
		JLabel lOwner = new JLabel("*Owner	", FlowLayout.LEFT);
		JLabel lYear = new JLabel("*Year					", FlowLayout.LEFT);

		JButton finish = new JButton("Save");

		final JTextField year = new JTextField(15);
		final JTextField modelField = new JTextField(15);
		final JTextField manufacturer = new JTextField(11);
		final JTextField owner = new JTextField(15);
		JPanel panel = new JPanel();

		for (TransportInterface vehicle : data) {
			if (vehicle.getModel().equalsIgnoreCase(model)) {

				index = (int) data.indexOf(vehicle);

				modelField.setText(data.get(index).getModel());
				manufacturer.setText(data.get(index).getManufacturer());
				owner.setText(data.get(index).getOwner());
				year.setText(Integer.toString(data.get(index)
						.getYearOfProduction()));

			}

		}

		if (index == -1) {

			JOptionPane.showMessageDialog(null, "You entered wrong model!");
			showInfo.setVisible(false);
		} else {
			showInfo.setVisible(true);
			finish.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					String modelNew = modelField.getText();
					String ownerNew = owner.getText();
					String manufNew = manufacturer.getText();
					int yearNew = Integer.parseInt(year.getText());

					data.get(index).setManufacturer(manufNew);
					data.get(index).setModel(modelNew);
					data.get(index).setYear(yearNew);
					data.get(index).setOwner(ownerNew);

					((TransportTableModel) table.getModel())
							.fireTableDataChanged();
					showInfo.setVisible(false);

				}
			});
		}

		editDialog.setVisible(false);
		panel.add(lModel);
		panel.add(modelField);
		panel.add(lManufacturer);
		panel.add(manufacturer);
		panel.add(lOwner);
		panel.add(owner);
		panel.add(lYear);
		panel.add(year);
		panel.add(finish);
		showInfo.add(panel);
	}

	public static void main(String[] args) {

		Gui go = new Gui();

	}

}
