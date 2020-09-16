package comparators;

import java.util.Comparator;

public class ComparatorByString implements Comparator<String> {

	@Override
	public int compare(String partialNote1, String partialNote2) {
		int result = 0;
		if( partialNote1.compareTo(partialNote2) > 0) {
			result =  1;
		}
		if( partialNote1.compareTo(partialNote2) < 0) {
			result =  -1;
		}
		if( partialNote1.compareTo(partialNote2) == 0) {
			result =  0;
		}
		return result;

	}

}
