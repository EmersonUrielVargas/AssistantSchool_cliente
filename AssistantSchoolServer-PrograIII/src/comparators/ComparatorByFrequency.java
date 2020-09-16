package comparators;

import java.util.Comparator;

public class ComparatorByFrequency implements Comparator<Integer> {

	public int compare(Integer word1, Integer word2) {
		int result = 0;
		if(word1<word2) {
			 result = -1;
		}		if(word1>word2) {
			 result = 1;
		}		if(word1==word2) {
			 result = 0;
		}
		return result;
	}
}
