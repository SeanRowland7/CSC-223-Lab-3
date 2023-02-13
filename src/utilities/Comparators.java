package utilities;

import java.util.Comparator;

public class Comparators {

	static Comparator<Integer> intCompare = new Comparator<Integer>() {
		
		public int compare(Integer x, Integer y) {
			
			return x % 2 == y % 2 ? 0 : 1;
			
		}
	};
	
	static Comparator<String> lengthCompare = new Comparator<String>() {
		
		public int compare(String x, String y) {
			
			return x.length() % 2 == y.length() % 2 ? 0 : 1;
			
		}
		
	};
	
	static Comparator<Integer> negativeCompare = new Comparator<Integer>() {
		
		public int compare(Integer x, Integer y) {
			
			return (x < 0) == (y < 0) ? 0 : 1;
			
		}
		
	};
	
}
