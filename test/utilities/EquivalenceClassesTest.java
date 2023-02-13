package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

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
	void testMod3Add() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.int3Compare);

		test.add(1);

		assertEquals(1, test.size());

		assertEquals(1, test.numClasses());

		assertTrue(test.contains(1));

		assertEquals(0, test.indexOfClass(1));

		test.add(3);

		test.add(2);

		assertEquals(3, test.size());

		assertEquals(3, test.numClasses());

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

	@Test
	void testContainsSimple() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		test.add(1);

		test.add(2);

		assertTrue(test.contains(1));

		assertFalse(test.contains(3));

	}

	@Test
	void testContainsStress() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 101; i++) {

			test.add(i);

		}

		for(int i = 1; i < 101; i++) {

			assertTrue(test.contains(i));

		}

	}

	@Test
	void testSize() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		assertEquals(0, test.size());

		test.add(1);

		assertEquals(1, test.size());

	}

	@Test
	void testSizeStress() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 101; i++) {

			test.add(i);

			assertEquals(i, test.size());

		}

	}

	@Test
	void testIndexOf() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		test.add(2);

		assertEquals(0, test.indexOfClass(2));

		test.add(1);

		assertEquals(1, test.indexOfClass(1));
		
		assertEquals(0, test.indexOfClass(100));
		
		assertEquals(1, test.indexOfClass(33));

	}

	@Test
	void testIndexOfStress() {

		Comparator<Integer> int4Compare = new Comparator<Integer>() {

			public int compare(Integer x, Integer y) {

				return x % 4 == y % 4 ? 0 : 1;

			}
		};

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(int4Compare);

		for(int i = 1; i < 101; i++) {

			test.add(i);

		}

		for(int i = 1; i < 101; i++) {
			
			if(i % 4 == 0) {
				
				assertEquals(3, test.indexOfClass(i));
				
			}
			
			else {
			
				assertEquals((i % 4) - 1, test.indexOfClass(i));
				
			}

		}
		
	}

}
