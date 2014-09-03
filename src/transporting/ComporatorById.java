package transporting;

import java.util.Comparator;

public class ComporatorById implements Comparator<TransportInterface>{

	@Override
	public int compare(TransportInterface vehicle1, TransportInterface vehicle2) {
		
		return vehicle1.getIdentifier().compareToIgnoreCase(vehicle2.getIdentifier());
	}

	

}
