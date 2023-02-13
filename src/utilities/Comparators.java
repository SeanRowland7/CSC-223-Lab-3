package utilities;

import java.util.Comparator;

public class Comparators {

	static Comparator<Integer> simple = new Comparator<Integer>() {
		
		public int compare(Integer x, Integer y) {
			
			return x % 2 == y % 2 ? 0 : 1;
			
		}
	};
	
}
