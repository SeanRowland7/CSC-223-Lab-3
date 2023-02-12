package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.LinkedList;

class LinkedListTest {

	public LinkedList<Integer> buildInt() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 11; i++) {

			list.addToBack(i);

		}

		return list;

	}
	@Test
	void addToFrontTest() 
	{
		LinkedList <Integer> a = new LinkedList <Integer>();

		a.addToFront(5);

		a.addToFront(4);

		assertEquals(a.size(),2);

		assertTrue(a.contains(5));

		assertTrue(a.contains(4));

	}

	@Test
	void addToFrontStressTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 100; i++) {

			list.addToFront(i);

			assertEquals(i, list.size());

			for(int j = 1; j <= i; j++) {

				assertTrue(list.contains(j));

			}

		}

	}

	@Test
	void addToBackTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		list.addToBack(1);

		list.addToBack(2);

		assertEquals(2, list.size());

		assertTrue(list.contains(1));

		assertTrue(list.contains(2));

	}

	@Test
	void addToBackStressTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 100; i++) {

			list.addToBack(i);

			assertEquals(i, list.size());

			for(int j = 1; j <= i; j++) {

				assertTrue(list.contains(j));

			}

		}

	}

	@Test
	void sizeAddTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		assertEquals(0, list.size());

		list.addToBack(1);

		assertEquals(1, list.size());

	}

	@Test
	void sizeAddStressTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 100; i++) {

			list.addToFront(i);

			assertEquals(i, list.size());

		}

	}

	@Test
	void sizeRemoveTest() {

		LinkedList<Integer> list = buildInt();

		assertEquals(10, list.size());

		list.remove(1);

		assertEquals(9, list.size());

	}

	@Test
	void sizeRemoveStressTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 100; i++) {

			list.addToFront(i);

			assertEquals(i, list.size());

		}

		for(int i = 99; i > 0; i--) {

			assertEquals(i, list.size());

			list.remove(i);

		}

	}

	@Test
	void removeTest() {

		LinkedList<Integer> list = buildInt();

		assertEquals(10, list.size());

		list.remove(10);

		assertEquals(9, list.size());

		assertFalse(list.contains(10));

	}

	@Test
	void removeStressTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 100; i++) {

			list.addToFront(i);

			assertEquals(i, list.size());

			for(int j = 1; j <= i; j++) {

				assertTrue(list.contains(j));

			}

		}

		for(int i = 99; i > 0; i--) {

			assertEquals(i, list.size());

			list.remove(i);

			for(int j = 1; j <= i - 1; j++) {

				assertTrue(list.contains(j));

			}

		}

		assertTrue(list.isEmpty());

	}

	@Test
	void isEmptyTest() {

		LinkedList<Integer> list = buildInt();

		assertFalse(list.isEmpty());

		list.clear();

		assertTrue(list.isEmpty());

	}

	@Test
	void isEmptyStress() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 100; i++) {

			list.addToFront(i);

			assertFalse(list.isEmpty());

		}

		for(int i = 99; i > 0; i--) {

			list.remove(i);

		}

		assertTrue(list.isEmpty());

	}

	@Test
	void containsTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		assertEquals(0, list.size());

		list.addToBack(1);

		assertTrue(list.contains(1));

	}

	@Test
	void containsStressTest() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		for(int i = 1; i < 100; i++) {

			list.addToFront(i);

			assertEquals(i, list.size());

			for(int j = 1; j <= i; j++) {

				assertTrue(list.contains(j));

			}

		}

	}
	
	@Test
	void clearTest() {
		
		LinkedList<Integer> list = buildInt();
		
		assertFalse(list.isEmpty());
		
		list.clear();
		
		assertTrue(list.isEmpty());
		
	}

}
