package utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EquivalenceClasses<T> 
{
	
	protected Comparator<T> _comparator;
	
	protected List<LinkedEquivalenceClass<T>> _classes;
	
	public EquivalenceClasses(Comparator<T> comparator) {
		
		_comparator = comparator;
		
		_classes = new ArrayList<LinkedEquivalenceClass<T>>();
		
	}
	
	// need to make a new list with a new equivalence class to fit it
	
	public boolean add(T element) {
		
		for(LinkedEquivalenceClass<T> list : _classes) {
			
			if(list.belongs(element)) {
				
				list.add(element);
				
				return true;
				
			}
			
		}
		
		_classes.add(new LinkedEquivalenceClass<T>(_comparator));
		
		return true;
		
	}
	
	public boolean contains(T element) {
		
		return _classes.contains(element);
		
	}
	
	public int size() {
		
		int size = 0;
		
		for(LinkedEquivalenceClass<T> list : _classes) {
			
			size = size + list.size();
			
		}
		
		return size;
		
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
