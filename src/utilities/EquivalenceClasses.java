package utilities;

import java.util.Comparator;
import java.util.List;

public class EquivalenceClasses<T> 
{
	
	protected Comparator<T> _comparator;
	
	protected List<LinkedEquivalenceClass<T>> _classes;
	
	public EquivalenceClasses(Comparator<T> comparator, List<LinkedEquivalenceClass<T>> classes) {
		
		_comparator = comparator;
		
		_classes = classes;
		
	}
	
	public boolean add(T element) {
		
		for(LinkedEquivalenceClass<T> list : _classes) {
			
			if(list.belongs(element)) {
				
				list.add(element);
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public boolean contains(T element) {
		
		return _classes.contains(element);
		
	}
	
	public int size() {
		
		int size = 0;
		
		for(LinkedEquivalenceClass<T> list : _classes) {
			
			size = size + list.size()
			
		}
		
	}
	
	public int numClasses() {
		
		return _classes.size();
		
	}
	
	protected int indexOfClass(T element) {
		
		int index = 0;
		
		for(; index < _classes.size(); index++) {
			
			if(_classes.get(index).belongs(element)) return index;
			
		}
	
		return -1;
		
	}
	
	public String toString() {
		
		String str = "";
		
		for(LinkedEquivalenceClass<T> list : _classes) {
			
			str = str + ", " + list.toString();
			
		}
		
		return str;
		
	}

}
