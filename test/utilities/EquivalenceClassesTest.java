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

		EquivalenceClasses<Integer> test2 = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 11; i++) {

			test2.add(i);
		}

		assertEquals(10,test2.size());

		assertEquals(2,test2.numClasses());

		assertEquals(0, test.indexOfClass(1));

		assertEquals(", {1 | 9, 7, 5, 3}, {2 | 10, 8, 6, 4}",test2.toString());

		EquivalenceClasses<Integer> test3 = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 101; i++) {

			test3.add(i);
		}

		assertEquals(100,test3.size());
		assertEquals(2,test3.numClasses());

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

		EquivalenceClasses<Integer> test2 = new EquivalenceClasses<Integer>(Comparators.negativeCompare);

		for(int i = 1; i < 11; i++) {

			test2.add(i);
		}

		for(int i = -10; i < 0; i++) {

			test2.add(i);
		}

		assertEquals(20, test2.size());

		assertEquals(2, test2.numClasses());

		assertEquals(", {1 | 10, 9, 8, 7, 6, 5, 4, 3, 2}, {-10 | -1, -2, -3, -4, -5, -6, -7, -8, -9}", test2.toString());

		EquivalenceClasses<Integer> test3 = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 101; i++) {

			test3.add(i);
		}
		for(int i = -100; i < 0; i++) {

			test3.add(i);
		}

		assertEquals(200,test3.size());

		assertEquals(3,test3.numClasses());

		assertEquals(0,test3.indexOfClass(1));

		assertEquals(1,test3.indexOfClass(2));

		assertEquals(0,test3.indexOfClass(3));

	}

	@Test
	void testContians() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 5; i++) {

			test.add(i);
		}

		assertTrue(test.contains(1));
		assertTrue(test.contains(2));
		assertTrue(test.contains(3));
		assertTrue(test.contains(4));

		assertEquals(2, test.numClasses());

		assertEquals(0, test.indexOfClass(1));
		assertEquals(1, test.indexOfClass(2));




		EquivalenceClasses<Integer> test2 = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 101; i++) {

			test2.add(i);
		}

		assertTrue(test2.contains(100));
		assertTrue(test2.contains(50));
		assertTrue(test2.contains(1));

		assertEquals(2, test2.numClasses());

		assertEquals(0, test2.indexOfClass(1));
		assertEquals(1, test2.indexOfClass(2));


	}

	@Test
	void testSize() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 11; i++) {

			test.add(i);

		}
		assertEquals(10, test.size());

		assertEquals(", {1 | 9, 7, 5, 3}, {2 | 10, 8, 6, 4}", test.toString());


		EquivalenceClasses<Integer> test2 = new EquivalenceClasses<Integer>(Comparators.intCompare);


		for(int i = 1; i < 101; i++) {

			test2.add(i);

		}

		assertEquals(2, test2.numClasses());

		assertEquals(100, test2.size());

	}

	@Test
	void testNumClasses() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 11; i++) {

			test.add(i);

		}

		assertEquals(2, test.numClasses());

		assertEquals(10, test.size());

		EquivalenceClasses<Integer> test2 = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 101; i++) {

			test2.add(i);

		}

		assertEquals(2, test2.numClasses());

		assertEquals(100, test2.size());

	}

	@Test
	void toStringTest() {

		EquivalenceClasses<Integer> test = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 11; i++) {

			test.add(i);

		}

		assertEquals(10, test.size());

		assertEquals(2, test.numClasses());

		assertEquals(", {1 | 9, 7, 5, 3}, {2 | 10, 8, 6, 4}", test.toString());

		EquivalenceClasses<Integer> test2 = new EquivalenceClasses<Integer>(Comparators.intCompare);

		for(int i = 1; i < 11; i++) {

			test2.add(i);

		}
		
		for(int i = -10; i < 0; i++) {

			test2.add(i);
		}
		
		assertEquals(20, test2.size());

		assertEquals(3, test2.numClasses());
		
		assertEquals(", {1 | 9, 7, 5, 3}, {2 | -2, -4, -6, -8, -10, 10, 8, 6, 4}, {-9 | -1, -3, -5, -7}", test2.toString());


	}


}
