package transporting;

import java.util.Comparator;

public class ComparatorByType implements Comparator<TransportInterface>{

	@Override
	public int compare(TransportInterface vehicle1, TransportInterface vehicle2) {
		
		return vehicle1.getType().compareToIgnoreCase(vehicle2.getType());
	}

	

}
