package utilities.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ExamPractice.DoublyLinkedList;
import utilities.LinkedList;

class LinkedListTest {

	@Test
	void addToFrontTest() 
	{
		LinkedList <Integer> a = new LinkedList <Integer>();
		
		int n = 10;
		
		while(a.size()!= 10)
		{
			a.addToFront(n);
			
			n = n - 1;
		}
		
		assertEquals(a.size(),10);
		
		System.out.println(a.toString());

	}
	
	@Test
	void RemoveTest() 
	{
		LinkedList <Integer> a = new LinkedList <Integer>();
		
		int n = 10;
		
		while(a.size()!= 10)
		{
			a.addToFront(n);
			
			n = n - 1;
		}
		
		assertEquals(a.size(),10);
		
		a.remove(5);
		a.remove(4);
		a.remove(7);
		
		assertFalse(a.contains(5));
		assertFalse(a.contains(4));
		assertFalse(a.contains(7));
		
		assertEquals(a.size(),7);
		
		
		System.out.println(a.toString());

	}
	
	@Test
	void ContainsTest() 
	{
		LinkedList <Integer> a = new LinkedList <Integer>();
		
		int n = 10;
		
		while(a.size()!= 10)
		{
			a.addToFront(n);
			
			n = n - 1;
		}
		
		assertEquals(a.size(),10);
		
		a.remove(5);
		a.remove(4);
		a.remove(7);
		
		assertFalse(a.contains(5));
		assertFalse(a.contains(4));
		assertFalse(a.contains(7));
		
		assertTrue(a.contains(1));
		assertTrue(a.contains(2));
		assertTrue(a.contains(3));
		assertTrue(a.contains(5));
		
		assertEquals(a.size(),7);
		
		
		System.out.println(a.toString());

	}
	
	
	
	

}
