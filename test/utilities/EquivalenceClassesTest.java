package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EquivalenceClassesTest {
	
	@Test
	void testBuild() 
	{
		
		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.simple);
		
		assertEquals(0, test.size());
		
		assertEquals(0, test.numClasses());

	}
	
	@Test
	void testAdd() {
		
		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.simple);
		
		test.add(1);
		
		assertEquals(1, test.size());
		
		assertEquals(1, test.numClasses());
		
		assertTrue(test.contains(1));
		
	}

}
