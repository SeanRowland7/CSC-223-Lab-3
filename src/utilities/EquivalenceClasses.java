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
		
		if(_classes.belongs(element)) {
			
			_classes.add(element);
			
			return true;
			
		}
		
		return false;
		
	}

}
