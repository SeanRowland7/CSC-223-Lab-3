package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class LinkedEquivalenceClassTest 
{

	
	@Test
	void canonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void isEmptyTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		assertTrue(eq1.isEmpty());
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertFalse(eq1.isEmpty());
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		eq1.clearNonCanonical();
		assertFalse(eq1.isEmpty());
		
		eq1.removeCanonical();
		assertTrue(eq1.isEmpty());
		
		eq1.add(2);	
		assertFalse(eq1.isEmpty());
		eq1.clear();
		assertTrue(eq1.isEmpty());
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
		
		eq2.clearNonCanonical();
		assertFalse(eq2.isEmpty());
		
		eq2.removeCanonical();
		assertTrue(eq2.isEmpty());
		
		eq2.add("boo");	
		assertFalse(eq2.isEmpty());
		eq2.clear();
		assertTrue(eq2.isEmpty());
	}

	@Test
	void clearTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		assertTrue(eq1.isEmpty());
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	

		assertFalse(eq1.isEmpty());
		eq1.clear();
		assertTrue(eq1.isEmpty());
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
	
		assertFalse(eq2.isEmpty());
		eq2.clear();
		eq2.clear();
		assertTrue(eq2.isEmpty());
		
	}
	
	@Test
	void clearNonCanonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void sizeTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void addTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void containsTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void belongsTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void removeTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}
	
	@Test
	void removeCanonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}

	@Test
	void demoteAndSetCanonicalTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}
	
	@Test
	void toStringTest() 
	{
		Comparator<Integer> c1 = new Comparator<Integer>()  
		{
			// All even integers are 'equivalent' 
			public int compare(Integer x, Integer y) { return x % 2 == y % 2 ? 0 : 1; } 
		};
		
		LinkedEquivalenceClass<Integer> eq1 = new LinkedEquivalenceClass<Integer>(c1);
			
		eq1.add(1);
		eq1.add(2);	
		eq1.add(3);	
		assertEquals("{1 | 3}", eq1.toString());
		assertEquals(1, eq1.canonical());
		
		eq1.demoteAndSetCanonical(5);
		assertEquals("{5 | 1, 3}", eq1.toString());
		assertEquals(5, eq1.canonical());
		
		
		
		Comparator<String> c2 = new Comparator<String>()
		{
			// All Strings with same first character are 'equivalent'
			public int compare(String x, String y) 
			{ 
				if(x.length() == 0 || y.length() == 0) return 1;
				
				return x.charAt(0) == y.charAt(0) ? 0 : 1; 
			}
		};
		
		LinkedEquivalenceClass<String> eq2 = new LinkedEquivalenceClass<String>(c2);
																				
		eq2.add("apple");	
		eq2.add("bin");	
		eq2.add("air");	
		eq2.add("answer");	
		
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("cat");
		assertEquals("{apple | answer, air}", eq2.toString());
		assertEquals("apple", eq2.canonical());
		
		eq2.demoteAndSetCanonical("animal");
		assertEquals("{animal | apple, answer, air}", eq2.toString());
		assertEquals("animal", eq2.canonical());
	}


}
