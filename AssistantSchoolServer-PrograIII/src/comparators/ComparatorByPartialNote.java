package comparators;

import java.util.Comparator;

import models.PartialNote;

public class ComparatorByPartialNote implements Comparator<PartialNote> {

	@Override
	public int compare(PartialNote partialNote1, PartialNote partialNote2) {
		int result = 0;
		if( partialNote1.getTopic().compareTo(partialNote2.getTopic()) > 0) {
			result =  1;
		}
		if( partialNote1.getTopic().compareTo(partialNote2.getTopic()) < 0) {
			result =  -1;
		}
		if( partialNote1.getTopic().compareTo(partialNote2.getTopic()) == 0) {
			result =  0;
		}
		return result;
	}

}
