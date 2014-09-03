package transporting.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import transporting.Balloon;
import transporting.Bike;
import transporting.Boat;
import transporting.Bus;
import transporting.Car;
import transporting.MotorBoat;
import transporting.Motorbike;
import transporting.Plane;
import transporting.Ship;
import transporting.Shuttle;
import transporting.TransportInterface;
import transporting.Truck;
import transporting.WindSurf;

public class TransportTableModel extends AbstractTableModel {
	
	public List<TransportInterface> data;
	
	public String[] columnsName = {"Name", "Model", "Identifier", "Manufacturer", "Year", "Owner"};

	public TransportTableModel(List<TransportInterface> data ){
		this.data = data;
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		super.setValueAt(aValue, rowIndex, columnIndex);
	}

	@Override
	public int getColumnCount() {
		return columnsName.length;
	}

	@Override
	public int getRowCount() {
		return this.data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		TransportInterface transport =  data.get(rowIndex);
		
		switch (columnIndex)
		{
		case 0:
			return transport.getName();
		case 1:
			return transport.getModel();
		case 2:
			if(transport.getName().equals("Car")){
				Car c = (Car)transport;
				return c.getIdentifier();
			}else if (transport.getName().equals("Bus")){
				Bus b = (Bus)transport;
				return b.getIdentifier();
			}else if (transport.getName().equals("Truck")){
				Truck tr = (Truck)transport;
				return tr.getIdentifier();
			}else if (transport.getName().equals("MotorBike")){
				Motorbike mb = (Motorbike)transport;
				return mb.getIdentifier();	
			}else if (transport.getName().equals("Bike")){
				Bike bike = (Bike)transport;
				return bike.getIdentifier();
			}else if (transport.getName().equals("Plane")){
				Plane plane = (Plane)transport;
				return plane.getIdentifier();
			}else if (transport.getName().equals("Shuttle")){
				Shuttle sh = (Shuttle)transport;
				return sh.getIdentifier();
			}else if (transport.getName().equals("Balloon")){
				Balloon bl = (Balloon)transport;
				return bl.getIdentifier();
			}else if (transport.getName().equals("Ship")){
				Ship ship = (Ship)transport;
				return ship.getIdentifier();
			}else if (transport.getName().equals("MotorBoat")){
				MotorBoat mob = (MotorBoat)transport;
				return mob.getIdentifier();
			}else if (transport.getName().equals("WindSurf")){
				WindSurf ws = (WindSurf)transport;
				return ws.getIdentifier();
			}else if (transport.getName().equals("Boat")){
				Boat boat = (Boat)transport;
				return boat.getIdentifier();
			}else{
				return -1;
			}
		case 3:
			if(transport.getName().equals("Car")){
				Car c = (Car)transport;
				return c.getManufacturer();
			}else if (transport.getName().equals("Bus")){
				Bus b = (Bus)transport;
				return b.getManufacturer();
			}else if (transport.getName().equals("Truck")){
				Truck tr = (Truck)transport;
				return tr.getManufacturer();
			}else if (transport.getName().equals("MotorBike")){
				Motorbike mb = (Motorbike)transport;
				return mb.getManufacturer();	
			}else if (transport.getName().equals("Bike")){
				Bike bike = (Bike)transport;
				return bike.getManufacturer();
			}else if (transport.getName().equals("Plane")){
				Plane plane = (Plane)transport;
				return plane.getManufacturer();
			}else if (transport.getName().equals("Shuttle")){
				Shuttle sh = (Shuttle)transport;
				return sh.getManufacturer();
			}else if (transport.getName().equals("Balloon")){
				Balloon bl = (Balloon)transport;
				return bl.getManufacturer();
			}else if (transport.getName().equals("Ship")){
				Ship ship = (Ship)transport;
				return ship.getManufacturer();
			}else if (transport.getName().equals("MotorBoat")){
				MotorBoat mob = (MotorBoat)transport;
				return mob.getManufacturer();
			}else if (transport.getName().equals("WindSurf")){
				WindSurf ws = (WindSurf)transport;
				return ws.getManufacturer();
			}else if (transport.getName().equals("Boat")){
				Boat boat = (Boat)transport;
				return boat.getManufacturer();
			}else{
				return -1;
			}
		case 4:
			if(transport.getName().equals("Car")){
				Car c = (Car)transport;
				return c.getYearOfProduction();
			}else if (transport.getName().equals("Bus")){
				Bus b = (Bus)transport;
				return b.getYearOfProduction();
			}else if (transport.getName().equals("Truck")){
				Truck tr = (Truck)transport;
				return tr.getYearOfProduction();
			}else if (transport.getName().equals("MotorBike")){
				Motorbike mb = (Motorbike)transport;
				return mb.getYearOfProduction();	
			}else if (transport.getName().equals("Bike")){
				Bike bike = (Bike)transport;
				return bike.getYearOfProduction();
			}else if (transport.getName().equals("Plane")){
				Plane plane = (Plane)transport;
				return plane.getYearOfProduction();
			}else if (transport.getName().equals("Shuttle")){
				Shuttle sh = (Shuttle)transport;
				return sh.getYearOfProduction();
			}else if (transport.getName().equals("Balloon")){
				Balloon bl = (Balloon)transport;
				return bl.getYearOfProduction();
			}else if (transport.getName().equals("Ship")){
				Ship ship = (Ship)transport;
				return ship.getYearOfProduction();
			}else if (transport.getName().equals("MotorBoat")){
				MotorBoat mob = (MotorBoat)transport;
				return mob.getYearOfProduction();
			}else if (transport.getName().equals("WindSurf")){
				WindSurf ws = (WindSurf)transport;
				return ws.getYearOfProduction();
			}else if (transport.getName().equals("Boat")){
				Boat boat = (Boat)transport;
				return boat.getYearOfProduction();
			}else{
				return -1;
			}
		case 5:
			if(transport.getName().equals("Car")){
				Car c = (Car)transport;
				return c.getOwner();
			}else if (transport.getName().equals("Bus")){
				Bus b = (Bus)transport;
				return b.getOwner();
			}else if (transport.getName().equals("Truck")){
				Truck tr = (Truck)transport;
				return tr.getOwner();
			}else if (transport.getName().equals("MotorBike")){
				Motorbike mb = (Motorbike)transport;
				return mb.getOwner();	
			}else if (transport.getName().equals("Bike")){
				Bike bike = (Bike)transport;
				return bike.getOwner();
			}else if (transport.getName().equals("Plane")){
				Plane plane = (Plane)transport;
				return plane.getOwner();
			}else if (transport.getName().equals("Shuttle")){
				Shuttle sh = (Shuttle)transport;
				return sh.getOwner();
			}else if (transport.getName().equals("Balloon")){
				Balloon bl = (Balloon)transport;
				return bl.getOwner();
			}else if (transport.getName().equals("Ship")){
				Ship ship = (Ship)transport;
				return ship.getOwner();
			}else if (transport.getName().equals("MotorBoat")){
				MotorBoat mob = (MotorBoat)transport;
				return mob.getOwner();
			}else if (transport.getName().equals("WindSurf")){
				WindSurf ws = (WindSurf)transport;
				return ws.getOwner();
			}else if (transport.getName().equals("Boat")){
				Boat boat = (Boat)transport;
				return boat.getOwner();
			}else{
				return -1;
			}
		}
				
		return null;
		
	}

	@Override
	public String getColumnName(int columnIndex) {	
		return columnsName[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int col) {	
		return false;
	}
	
//	public void addVehicle(TransportInterface tr){
//		ArrayList<TransportInterface> data1 = new ArrayList<TransportInterface>();
//		
//		data1.add(tr);
//		super.fireTableRowsInserted(0, data.size());
//	}

}
