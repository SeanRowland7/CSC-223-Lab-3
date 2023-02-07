package utilities.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ExamPractice.DoublyLinkedList;

class LinkedListTest {

	@Test
	void addToFrontTest() 
	{
		LinkedList <Integer> a = new LinkedList <Integer>();
		
		a.addToFront(5);
		a.addToFront(4);
		
		assertEquals(a.size(),2);
		
		assertTrue(a.contains(5));
		
		System.out.println(a.toString());

	}

}
