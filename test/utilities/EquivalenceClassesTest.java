package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquivalenceClassesTest {
	
	@Test
	void testBuild() 
	{
		
		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);
		
		assertEquals(0, test.size());
		
		assertEquals(0, test.numClasses());

	}
	
	@Test
	void testModAdd() {
		
		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);
		
		test.add(1);
		
		assertEquals(1, test.size());
		
		assertEquals(1, test.numClasses());
		
		assertTrue(test.contains(1));
		
		assertEquals(0, test.indexOfClass(1));
		
	}
	
	@Test
	void testNegativeAdd() {
		
		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.negativeCompare);
		
		test.add(-1);
		
		test.add(1);
		
		assertEquals(2, test.size());
		
		assertEquals(2, test.numClasses());
		
		test.add(2);
		
		assertEquals(3, test.size());
		
		assertEquals(2, test.numClasses());
		
		
	}
	
	@Test
	void testNumClasses() {
		
		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);
		
		for(int i = 1; i < 101; i++) {
			
			test.add(i);
			
		}
		
		assertEquals(2, test.numClasses());
		
		assertEquals(100, test.size());
		
	}

}
