package comparators;

import java.util.Comparator;

import models.FinalNote;

public class ComparatorByFinalNoteStudent implements Comparator<FinalNote> {
	
	@Override
	public int compare(FinalNote partialNote1, FinalNote partialNote2) {
		int result = 0;
		if( partialNote1.getSubject()>partialNote2.getSubject()) {
			result =  1;
		}
		if( partialNote1.getSubject()<partialNote2.getSubject()) {
			result =  -1;
		}
		if(partialNote1.getSubject()==partialNote2.getSubject()) {
			result =  0;
		}
		return result;
	}
}
